/**
 * 1,000以下の素数を列挙(第3版)
 * 対象とする数の平方根以下のいずれの素数でも割り切れない場合その数は素数である
 */
fun main(args:Array<String>){
        //乗除算の回数
    var count = 0
        //素数を格納するList
    var primeList = mutableListOf<Int>()
    primeList.add(2) //2は素数である
    primeList.add(3) //3は素数である
        //対象とする数は奇数のみ
    for(n in 5..1000 step 2){
        var flg = false
        var i = 1

        loop@while (primeList[i] * primeList[i] <= n){
            count += 2
            if(n % primeList[i] === 0){
                flg = true
                break@loop
            }
            i++
        }

        if(!flg) {
            primeList.add(n)
            count++
        }
    }

    primeList.forEach{println(it)}
    println("乗除算を行った回数${count}")

}