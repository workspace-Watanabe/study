import java.awt.SystemTray
import java.util.*

fun main(args:Array<String>){
    print("整数を入力してください。")
    val scan = Scanner(System.`in`)
    val number = scan.nextInt()
    recur(number)
}

fun recur(n : Int){
    if(n > 0){
        recur(n-1)
        println(n)
        recur(n-2)
    }
}