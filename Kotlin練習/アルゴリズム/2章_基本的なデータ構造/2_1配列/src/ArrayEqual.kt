import java.util.*

/**
 * List2_7　
 *      二つの配列が等しいかどうかを比較
 *  演習2-4
 *      配列2の全要素を配列1にコピーするメソッドを作成せよ
 *  演習2-5
 *      配列2の全要素を配列1に逆順にコピーするメソッドを作成せよ
 */
fun main(args:Array<String>){
    val sc = Scanner(System.`in`)

    println("配列1の要素数を入力して下さい")
    val num = sc.nextInt()
    var array = arrayOfNulls<Int>(num)


    for(index in 0..array.size-1){
        println("array${index}の要素を入力してください")
       array[index] = sc.nextInt()
    }

    println("配列2の要素数を入力して下さい")
    val num2 = sc.nextInt()
    var array2 = arrayOfNulls<Int>(num2)


    for(index in 0..array2.size-1){
        println("array${index}の要素を入力してください")
        array2[index] = sc.nextInt()
    }

    val result =isCheckEquals(array,array2,::isEqualLength,::isEqualsElement)

    println("配列1と2は" + if(result) "等しいです" else "等しくありません")
        //演習2-4
    array = copyArray(array,array2);
        //演習2-5
    array = rcopyArray(array,array2)
}
// ==================================================================================


    //２つの配列が等しいか調べる
private fun isCheckEquals(array: Array<Int?>, nextArray: Array<Int?>,
                          length:(Array<Int?>,Array<Int?>) -> Boolean,
                          element:(Array<Int?>,Array<Int?>) -> Boolean):Boolean{
    var result = true
    result = length(array,nextArray)
    if(result)  {
        result = element(array,nextArray)
    }
    else {
        return false
    };
    return result;
}

    //2つの配列の長さが等しいかどうか調べる
private fun isEqualLength(array: Array<Int?>, nextArray: Array<Int?>):Boolean{
    if(array.size === nextArray.size){
        return true;
    }
    return false;
}
    //２つの配列の要素が正しいか調べる
private fun isEqualsElement(array: Array<Int?>,nextArray: Array<Int?>):Boolean{
    for(i in 0..array.size-1){
        if(array[i] != nextArray[i]){
            return false;
        }
    }
    return true;
}

    //演習2-4
    // 配列2を配列1にコピー
private fun copyArray(a:Array<Int?>, b:Array<Int?>):Array<Int?>{
        val num = if(a.size >= b.size) b.size else a.size
        println("配列1に配列2をコピーします")
        for(i in 0..num-1){
            a[i] = b[i]
            println("array${i} :　${a[i]}")
        }
        return a
    }

    //演習2-5
    //配列2を配列1に逆順にコピー
private fun rcopyArray(a:Array<Int?>, b:Array<Int?>):Array<Int?>{
        val num = if(a.size >= b.size) b.size else a.size
        println("配列１に配列２を逆順にコピーします")
        for(i in num-1 downTo  0){
            a[i] = b[i]
            println("array${i} : ${a[i]}")
        }
        return a
    }