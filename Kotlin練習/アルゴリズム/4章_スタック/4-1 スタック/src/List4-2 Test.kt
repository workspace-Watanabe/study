import java.awt.image.AreaAveragingScaleFilter
import java.util.*

/**
 * 演習4-1
 *      ほかのメソッドを追加する
 */
fun main(args:Array<String>){
    val scan = Scanner(System.`in`)
    var stack = IntStack(64)

    while(true){
        println("現在のデータ数: ${stack.size()}/${stack.capacity()}")
        println("(1)プッシュ　(2)ポップ　(3)ピーク　(4)ダンプ　(5)要素を探す (6)空にする " +
                "(7)容量を見る (8)データ数を見る (9)空かどうかをチェックする (10)満杯かどうかをチェックする (0)終了")

        val menu = scan.nextInt()
        if(menu == 0) break //終了

        val index:Int
        val x:Int
        when(menu){
            1 -> {
               print("データを入力してください :")
                x = scan.nextInt()
                try{
                    stack.push(x)
                }catch (e:IntStack.OverflowIntStackException){
                    println("スタックが満杯です")
                }
            }

            2 -> {
               try{
                   x = stack.pop()
                   println("ポップしたデータは${x}です")
               }catch (e:IntStack.EmptyIntStackException){
                   println("スタックが空です")
               }
            }

            3 -> {
                try{
                    x = stack.peak()
                    println("ピークしたデータは${x}です")
                }catch (e:IntStack.EmptyIntStackException){
                    println("スタックが空です")
                }
            }
            4 -> stack.dump()

            5 -> {
                print("探す要素を入力してください")
                x = scan.nextInt()
                index = stack.indexOf(x)
                if(index != -1) println("その要素は${index}にあります。") else println("その要素は存在しません")
            }

            6 -> stack.clear()

            7 -> println("容量は${stack.capacity()}です")
            8 -> println("データ数は${stack.size()}です。")
            9 -> if(stack.isEmpty()) println("空です；；") else println("空ではありません")
            10 -> if(stack.isFull()) println("満杯です；；") else println("満杯ではありません")
        }
    }
}