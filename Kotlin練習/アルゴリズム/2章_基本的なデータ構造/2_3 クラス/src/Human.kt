

class Human(val name:String="guest", val height:Int=0, val vision:Double) {
    companion object{
        val VMAX:Int = 21
            //--身長の平均を求める--//
        fun aveHeight(date:Array<Human>):Double{
            var sum:Double = 0.0

            for((i,human) in date.withIndex()){
                sum += date[i].height
            }
            return sum/date.size
        }

            //--視力の分布を求める--//
            fun distVision(date:Array<Human>,dist:Array<Int>){
                dist[0] = 0
                for((i,number) in date.withIndex()){
                    if(number.vision >= 0.0 && date[i].vision <= (VMAX / 10.0))
                        dist[(date[i].vision*10).toInt()]++
                }

        }
    }
}

fun main(args:Array<String>){
    val humans:Array<Human> = arrayOf(Human("赤坂",162,0.3),
        Human("加藤",173,0.7),
        Human("斎藤",175,2.0),
        Human("武田",171,1.5),
        Human("長浜",174,1.2),
        Human("？？",169,0.8))

    var VDIST = Array<Int>(Human.VMAX,{it * 0})

    println("■　身体検査一覧表 ■")
    println("氏名　　身長　視力")

    for(i in humans){
        println("${i.name}　${i.height},　${i.vision}")
    }
    println("平均身長 :${Human.aveHeight(humans)}")
    Human.distVision(humans,VDIST)

    println("視力の分布\n")
    for(i in 0 until Human.VMAX){
        print("${(i/10.0).toDouble()}～ :")
        for(i in 0 until VDIST[i])
            print("★")
        println("")
    }

}