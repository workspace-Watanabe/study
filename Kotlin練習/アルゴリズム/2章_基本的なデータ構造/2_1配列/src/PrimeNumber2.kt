/**
 * 1000以下の素数を列挙(第2版)
 * 対象とする数より小さいすべての素数で割り切れなかったらその数も素数である
 */
fun main(args:Array<String>){
        //素数を格納するList
    var arrayPrimeNumber = mutableListOf<Int>()
        //2は素数であるため最初に入れておく
    arrayPrimeNumber.add(2)

    for(n in 3..1000){
        var i:Int = 0
        loop@for(primeNumber in arrayPrimeNumber){
            if(n % primeNumber === 0) break@loop
            i++
        }
        if(arrayPrimeNumber.size === i)
        arrayPrimeNumber.add(n)
    }


    arrayPrimeNumber.forEach{println(it)}
        


}