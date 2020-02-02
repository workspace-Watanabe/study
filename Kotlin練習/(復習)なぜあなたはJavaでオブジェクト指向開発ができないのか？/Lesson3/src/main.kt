
fun main(args:Array<String>){
    val judge = Judge()
    val you = Player("あなた")
    val enemy = Player("NPC")
    judge.startJanken(you,enemy)
}