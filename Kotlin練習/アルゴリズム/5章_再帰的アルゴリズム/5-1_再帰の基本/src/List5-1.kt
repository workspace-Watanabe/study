import java.util.*

/**
 * 階乗値を再帰的に求める
 * 演習5-1
 *  再帰を用いずに実現
 */
fun main(args:Array<String>){
    val scan = Scanner(System.`in`)
    println("整数を入力してください。")
    val number = scan.nextInt()
    println("${number}の階乗値は${factorial(number)}です。")
}


private fun factorial(n:Int) : Int{
   if(n > 0)
       return n * factorial(n-1)
    else
       return 1
}

private fun practice(n:Int) :Int{
    var number = n
    for(i in n-1 downTo 1){
        number *= i
    }
    return number
}
