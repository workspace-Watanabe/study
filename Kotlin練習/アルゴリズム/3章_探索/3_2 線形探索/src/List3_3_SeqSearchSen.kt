import java.util.*

/**
 * 番兵法を用いた線形探索
 *
 * 
 */
fun main(args:Array<String>){
    val scan = Scanner(System.`in`)
    println("要素数を入力してください。")
    val numberOfElement = scan.nextInt()
        //番兵法を使うため配列のサイズを一つ大きくする
    val array = arrayOfNulls<Int>(numberOfElement+1)
    //入力値を受け取る
    for(i in 0 until numberOfElement){
        print(("array${i}:"))
        array[i] = scan.nextInt()
    }

    print("探す値を入力してください:")
    val key = scan.nextInt()

    val indexOfElement = seqSearch(array,numberOfElement,key)

    if(indexOfElement == -1) println("その要素は存在しません") else println("その値はarray${indexOfElement}にあります。")
}

private fun seqSearch(array:Array<Int?>, n:Int, key:Int) :Int{
    array[n] = key
    var index = 0
    while(true){
        if(array[index] == key) break
        index++
    }
    return if(index == n) -1 else index
}

