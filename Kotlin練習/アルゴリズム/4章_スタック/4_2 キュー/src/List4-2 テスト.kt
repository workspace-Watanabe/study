import java.util.*

fun main(args:Array<String>){
    val query = IntQueue(64)
    val scan = Scanner(System.`in`)

    while(true){
        println("現在のデータ数 : ${query.size()} / ${query.capacity()}")
        print("(1)エンキュー (2)デキュー (3)ピーク (4)ダンプ (0)終了　" )
        // --------------------------------------------------------//
        val menu = scan.nextInt()
        if(menu == 0) break

        val element:Int?
        when(menu){
            1 -> {
                println("データを入力してください")
                element = scan.nextInt()
                try{
                    query.enque(element)
                }catch (e : IntQueue.OverflowIntQueueException){
                    println("キューが満杯です")
                }
            }

            2 -> {
                try{
                    element = query.deque()
                    println("デキューしたデータは${element}です。")
                }catch (e: IntQueue.EmptyIntQueueException){
                    println("キューが空です。")
                }
            }

            3 -> {
                try{
                    element = query.peek()
                    println("ピークしたデータは${element}です。")
                }catch (e : IntQueue.OverflowIntQueueException){
                    println("キューが空です。")
                }
            }




        }
    }
}