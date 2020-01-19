import java.util.*

/**
 * List2-8
 *      読みこんだ10進整数を2進数～36進数へと奇数変換して表示
 * 演習 2-6
 *      配列の先頭側に上位桁を格納するメソッドを作成せよ
 * 演習 2-7
 *      変換の過程を詳細に表すプログラムを作成せよ
 */
fun main(args:Array<String>){
        //変換する整数
    var number:Int;
        //基数
    var cd:Int;
        //変換後の桁数
    var dnumber:Int
        //変換後の各桁を格納する文字の配列
    var cnumber = arrayOfNulls<Char>(36)

    val scan = Scanner(System.`in`)
    println("10進数を奇数変換します")

        do{
            println("変換する非負の整数を入力してください。:")
            number =  scan.nextInt()
        }while (number < 0)

        do{
            println("何進数に変換しますか")
            cd = scan.nextInt()
        }while (36 < cd || cd < 2 )

        dnumber = cardConv(number,cd,cnumber)

        println("${cd}進数では")
        for(i in 0..dnumber-1){
            print(cnumber[i])
        }
        println("です。")
}


        //----整数値XをR進数に変換して配列Dに下位桁から格納して桁数を返却--//
    private fun cardConvR(X:Int, r:Int, d:Array<Char?>):Int{
            var x = X
                //変換後の桁数
            var digits = 0
            val dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

            do{
                d[digits++] = dchar.get(x%r)
                x /= r
            }while ( x != 0)
            return digits
        }

    //--演習2-6 上位桁を格納するメソッド --//
private fun cardConv(num:Int, radix:Int, listChar:Array<Char?>) : Int{
        var x = num
        var digits = 0
        val dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            println("${radix} | ${x}")
        do{
            listChar[digits++] = dchar.get(x%radix)
            x /= radix
            println("${radix} | ${x}...${x%radix}")
            println("　---")
        }while(x != 0)
        for(i in 0..(digits/2)-1){
           val tempChar :Char? = listChar[i]
            listChar[i] = listChar[digits-1-i]
            listChar[digits-1-i] = tempChar
        }

        return digits
    }


