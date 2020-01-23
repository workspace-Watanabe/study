import java.util.*

/**
 * 2分探索
 */
fun main(args:Array<String>){
    val scan = Scanner(System.`in`)
    println("要素数を入力してください:")
    val numberOfElement = scan.nextInt()

    println("昇順に入力してください。")
    val array = arrayOfNulls<Int>(numberOfElement)
    array[0] = scan.nextInt()
    for(i in 1 until numberOfElement){
        print("array${i}:")
        do{
            array[i] = scan.nextInt()
        }while(array[i]!! < array[i-1]!!)
    }

    println("探す値を入力してください。")
    val key = scan.nextInt()
    val indexOfElement = binSearch(array,numberOfElement,key)
    if(indexOfElement === -1) println("その要素は存在しません。") else println("その要素はarray${indexOfElement}にあります。")
}

/**
 * 配列arrayの先頭n個の要素からkeyと一致する要素を2分探索
 */
private fun binSearch(array: Array<Int?>, n:Int, key:Int):Int{
        //先頭のインデックス
    var pl = 0;
        //末尾のインデックス
    var pr = array.size-1

    do{
        val pc = (pl + pr) / 2
        if(array[pc] === key)
            return pc
        else if(array[pc]!! > key)
            pr = pc-1
        else
            pl = pc+1
    }while(pl <= pr)
    return -1
}