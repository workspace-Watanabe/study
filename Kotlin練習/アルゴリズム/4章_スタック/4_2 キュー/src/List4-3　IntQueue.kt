import java.lang.RuntimeException

class IntQueue{
    private var max:Int
    //先頭要素カーソル
    private var front:Int
    //末尾要素カーソル
    private var rear:Int
    //現在のデータ数
    private var num:Int
    //キューの本体
    private var que:IntArray

    //============== コンストラクタ ======================//
    constructor(capacity:Int){
        max = capacity
        front  = 0
        rear = 0
        num = 0
        que = IntArray(10)

    }

    // --------------- 実行時例外 : キューが空 ----------------- //
    class EmptyIntQueueException : RuntimeException(){}
    // --------------- 実行時例外　: キューが満杯 ---------------//
    class OverflowIntQueueException : RuntimeException(){}

    // ================================================================= //
    /// ===============================================================///

    /**
     * キューにデータをエンキュー
     */
    fun enque(element : Int):Int{
        if(num >= max)
            throw OverflowIntQueueException()
        que[rear++] = element
        num++
        if(rear == max)
            rear = 0
        return element
    }

    /**
     * キューからデータをでキュー
     */
    fun deque() : Int{
        if(num <= 0)
            throw EmptyIntQueueException()
        val element = que[front++]
        num--
        if(front == max)
            front = 0
        return element
    }

    /**
     * キューからデータをピック(先頭データを覗く)
     */
    fun peek() : Int {
        if(num <= 0)
            throw EmptyIntQueueException()
        return que[front]
    }

    /**
     * キューからelementを探してインデックスを返す
     */
    fun indexOf(element : Int) : Int{
        for(i in 0 until num){
            val index = (i + front) % max
            if(que[index] == element)
                return index
        }
        return -1
    }

    /**
     * キューを空にする
     */
    fun clear() {
        num = 0
        front = 0
        rear = 0
    }

    /**
     * キューの容量を返す
     *
     */
    fun capacity() : Int{
        return max
    }

    fun size() : Int{
        return num
    }

    /**
     * キューは空であるか
     */
    fun isEmpty() :Boolean{
        return num <= 0
    }

    /**
     * キューは満杯であるか
     */
    fun isFull() : Boolean{
        return num >= max
    }




}
