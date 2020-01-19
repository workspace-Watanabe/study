/**
 * 1000以下の素数を列挙する(第１版)
 */
fun main(args:Array<String>){
    var count = 0
    var countPrimeNumber = mutableListOf<Int>()
        //2からn-1までのどの値でも割り切れない数を調べる
    for(n in 2..1000){
      var i:Int = 2
        loop@ for(j in 2..n){

          if(n%j == 0){
              break@loop
          }
            i++
      }
       if(n == i) countPrimeNumber.add(n)
    }

        //最後に素数を出力
    for(primeNumber in countPrimeNumber){
        println(primeNumber)
    }
}