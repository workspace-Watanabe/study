import java.util.*

/**
 * List2-6
 *  配列の要素を反転させる
 *
 *  演習2_2　
 *  配列の並びの反転の経過を逐一表示させる
 *
 * 演習2_3
 *  配列の全要素の合計値を求める
 */
fun main(args:Array<String>){
    print("要素数を入力してください:")
    val scanner = Scanner(System.`in`)
    val num = scanner.nextInt()
        //配列の生成
    val array = arrayOfNulls<Int>(num)
        //配列の中身を入れる
    for(i in 0..array.size-1){
        array[i] = Random().nextInt(90)
        println("array${i}: ${array[i]}")
    }
        //要素の逆転
    reverse(array)
        //出力
    println("要素の並びを反転しました。")
    for(i in 0..array.size-1){
        println("array${i}: ${array[i]}")
    }

        //合計値を出力
   println( sumArray(array))
}

    //配列の要素を交換
private fun swap(target:Array<Int?>, index:Int, index2:Int){
            var t = target[index]
            target[index] = target[index2]
            target[index2] = t
}

    //配列の並びを反転
private fun reverse(args: Array<Int?>){
        for(i in 0..(args.size-1)/2){
            swap(args,i,args.size-1-i)
            passageRevese(args,i,args.size-1-i)
        }
    }
    //演習2-2: 経過を表示
private fun passageRevese(args: Array<Int?>, index:Int, nextIndex:Int){
        println("${index}と${nextIndex}を交換します")
        for(num in args){
            print("${num}　")
        }
        println("")
    }

    //演習2_3　合計値を求める
private fun sumArray(args: Array<Int?>): Int{
        var sum: Int = 0;
        for(number in args){
            sum += number!!
        }
        return sum
    }