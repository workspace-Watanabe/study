import java.util.*

/**
 * List3_1
 * 線形探索を行う
 */
fun main(args:Array<String>){
    val scan = Scanner(System.`in`)
    println("要素数を入力してください。")
    val numberOfElement = scan.nextInt()

    val array = arrayOfNulls<Int>(numberOfElement)
        //入力値を受け取る
    for(i in 0 until array.size){
        print(("array${i}:"))
        array[i] = scan.nextInt()
    }

    print("探す値を入力してください:")
    val key = scan.nextInt()

    val indexOfElement = seqSearch(array,numberOfElement,key)

    if(indexOfElement == -1) println("その要素は存在しません") else println("その値はarray${indexOfElement}にあります。")
}

private fun seqSearch(array:Array<Int?>, n:Int, key:Int) :Int{
    for((i,element) in array.withIndex()){
        if(element == key) return i
    }
    return -1
}