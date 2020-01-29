import java.util.*

/**
 * ユークリッドの互除法
 *
 * 演習5-2
 *      gcdを再帰メソッドを用いずに実現
 * 演習5-3
 *      配列aの全要素の最大公約数を求めるメソッドを作成
 */
fun main(args:Array<String>){
    val scan = Scanner(System.`in`)
    println("2つの整数の最大公約数を求めます。")
    println("整数を入力してください。")
    val number = scan.nextInt()
    println("整数を入力してください。")
    val number2 = scan.nextInt()
    println("最大公約数は${gcd(number,number2)}です。")
    println("最大公約数は${practiceList5_2(number,number2)}です。")

    val array = intArrayOf(33,55,33)
    println("最大公約数は${gcdArrayList5_3(array,0,3)}")
}

fun gcd(x:Int,y:Int) : Int{
    if(y == 0)
        return x
    else
        return gcd(y,x%y)
}

fun practiceList5_2 (x: Int,y: Int) : Int{
    var num = x
    var num2 = y
    while(num2 != 0){
        val n = num % num2
        num = num2
        num2 = n
    }
    return num
}

fun gcdArrayList5_3(intArray: IntArray, start:Int, number:Int) : Int{
    if(number == 1){
        return intArray[start]
    }else if(number == 2)
        return gcd(intArray[start],intArray[start+1])
    else
        return gcd(intArray[start],gcdArrayList5_3(intArray,start+1,number-1))
}