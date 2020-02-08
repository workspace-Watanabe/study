import java.util.*

fun main(args:Array<String>) {
    val scan = Scanner(System.`in`)
    println("単純交換ソート(バブルソート)")
    print("要素数 : ")
    val numberOfElement = scan.nextInt()
    val intArray: Array<Int> = Array(numberOfElement, { 0 })
    for (i in 0 until numberOfElement) {
        print("x${i} : ")
        intArray[i] = scan.nextInt()

    }
    bubbleSetNum2(intArray,numberOfElement)
    println("昇順にソートしました。")
    intArray.forEach { println(it) }
}


        /**
         * 配列内の要素を交換
         */
        fun swap(intArray: Array<Int>, index1:Int, index2:Int){
            val temp = intArray[index1]
            intArray[index1] = intArray[index2]
            intArray[index2] = temp
        }

        fun bubbleSort(intArray:Array<Int>, n : Int){
            for(i in 0 until n-1)
                for(j in n-1 downTo i+1){
                    if(intArray[j-1] > intArray[j])
                        swap(intArray,j-1,j)
                }
        }

        fun bubbleSetNum2(intArray: Array<Int>, n:Int){
            var k:Int = 0
            while(k < n-1){
                var last = n-1 //最後に交換した位置
                for(j in n-1 downTo k+1){
                    if(intArray[j-1] > intArray[j])
                        swap(intArray,j-1,j)
                }
                k = last
            }
        }

