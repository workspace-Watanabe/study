import java.lang.RuntimeException
import kotlin.math.max

class IntStack {
    private var maxOfStack: Int
    private var stackPointer: Int
    private var stack: Array<Int?> = arrayOfNulls(0)

        //--------- 実行時例外：スタックが例外 ----------//
        class EmptyIntStackException : RuntimeException() {}

        // --------- 実行時例外：スタックが満杯 ---------//
        class OverflowIntStackException : RuntimeException() {}

    //================ コンストラクター =============================//
    constructor(capacity: Int) {
        stackPointer = 0
        maxOfStack = capacity
        try {
            stack = arrayOfNulls(maxOfStack)
        } catch (e: OutOfMemoryError) {
            maxOfStack = 0
        }
    }


    // ----------- スタックにXをプッシュ
    // ---------   スタックポインターを１つ進める ----------//
    fun push(x: Int): Int {
        if (stackPointer >= maxOfStack)
            throw EmptyIntStackException()
        stack[stackPointer++] = x
        return x
    }

    // --------- スタックからデータをポップ(頂上のデータを取り出す) ----------//
    fun pop(): Int {
        if (stackPointer <= 0)
            throw  EmptyIntStackException()
        return stack[--stackPointer] ?: -1
    }

    // -------------- スタックからデータをピーク (頂上のデータをのぞき見) --------//
    fun peak(): Int {
        if (stackPointer <= 0)
            throw EmptyIntStackException()
        return stack[stackPointer - 1] ?: -1
    }

    // -------------- スタックから特定の要素を探してその要素のインデックス(無ければ-1)を返す ----//
    fun indexOf(element: Int): Int {
        for (i in (stackPointer - 1) downTo 0) {
            if (stack[i] == element) return i
        }
        return -1
    }

    //----------- スタックを空にする ---------//
    fun clear() {
        stackPointer = 0
    }

    // ---------- スタックの容量を返す ---------------//
    fun capacity() = maxOfStack

    // ----------- スタックに積まれているデータ数を返す -------------//
    fun size():Int = stackPointer

    // ------------ スタックは空であるか　--------//
    fun isEmpty() = stackPointer <= 0

    //------------- スタックは満杯であるか --------------//
    fun isFull() = stackPointer >= maxOfStack

    //-------------- スタック内の全データを底 -> 頂上の順に表示 ---------//
    fun dump(){
        if(stackPointer <= 0) println("スタックは空です。")
        else{
            for(i in 0 until stackPointer){
                println("stack${i}: ${stack[i]}")
            }
        }
    }
}
