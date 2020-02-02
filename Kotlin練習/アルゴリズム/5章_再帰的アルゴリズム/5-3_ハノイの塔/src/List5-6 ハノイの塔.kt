import java.util.*

/**
 * ハノイの塔
 */
fun main(args:Array<String>){
    val scan = Scanner(System.`in`)
    println("ハノイの塔")
    print("円盤の枚数を入力してください。 : ")
    val numberOfSheets = scan.nextInt()
    //no枚の円盤を1軸から3軸に移動
    moveTo(numberOfSheets,1,3)
}

/**
 * no枚の円盤をx軸からy軸に移動
 */
private fun moveTo(no:Int, x:Int, y:Int){
    if(no > 1)
        moveTo(no-1,x,6-x-y)
    println("円盤${no}を${x}軸から${y}軸に移動")
    if(no > 1)
        moveTo(no-1,6-x-y,y)
}