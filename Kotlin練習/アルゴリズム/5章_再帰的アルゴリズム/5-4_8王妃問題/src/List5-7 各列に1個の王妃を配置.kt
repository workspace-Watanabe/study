/**
 * 各列に1個の王妃を配置する組み合わせを再帰的に列挙
 *
 * List 5-8
 *      各行には王妃を一つだけ配置する
 * List 5-9
 *      8王妃問題を解く
 * 演習 5-8
 *     記号を用いて盤面を表示
 */
private var flag = Array(8){it -> false}
private var pos = arrayOfNulls<Int>(8)
private var flag_b = Array(15){it -> false}
private var flag_c = Array(15){it -> false}
//2次元配列
private var array = Array(8){it -> Array(8){it -> 8} }
fun main(args:Array<String>){
    set(0)
}

/**
 * 盤面を出力
 */
private fun print(){
   for(i in 0 until 8){
       for (j in 0 until 8){
           print(if(pos[j] == i) "■" else "□")
       }
       println()
   }
}

private fun set(i:Int){
    for(j in 0 until 8){
       if(flag[j] == false &&
           flag_b[i + j] == false &&
               flag_c[i-j+7] == false){

           pos[i] = j
           if(i == 7) {
               print()
           }
           else {
               flag[j] = true
               flag_b[i+j] = true
               flag_c[i-j+7] = true
               set(i + 1)
               flag[j] = false
               flag_b[i+j] = false
               flag_c[i-j+7] = false
           }
       }
    }
}


