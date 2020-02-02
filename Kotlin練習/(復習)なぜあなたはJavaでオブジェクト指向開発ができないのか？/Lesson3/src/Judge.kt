/**
 * ジャンケンの審判を表すクラス
 */
class Judge {
    /**
     * ジャンケンを開始する
     * @param 判定対象のプレーヤー
     * @param 判定対象のプレーヤー2
     */
    fun startJanken(player1:Player, player2: Player){
        println("【ジャンケン開始】")
        //3回勝負
        for(i in 0 until 3){
            println("【${i+1}回戦目】")
            val winner:Player? = judgeJanken(player1,player2)
            if(winner != null){
                println("${winner.name}が勝ちました！")
                winner?.notifyResult(true)
            }else
                println("引き分けです。")
        }
        println("【ジャンケン終了】")
        val finalWinner:Player? = judgeFinalWinner(player1,player2)
        if(finalWinner != null)
            println("勝者は${finalWinner?.name}です！")
        else
            println("引き分けです！")
    }

    /**
     * どちらが勝ちなのかを判断する
     */
    private fun judgeJanken(player1: Player,player2: Player):Player?{
        var winner : Player? = null
        //プレーヤー１の手を出す
        val player1hand = player1.showHand()
        //プレーヤー２の手を出す
        val player2hand = player2.showHand()

        //それぞれの手を表示する
        printHand(player1hand)
        print(" VS. ")
        printHand(player2hand)
        println()

        //プレーヤー1が勝つ場合
        if((player1hand == Player.STONE && player2hand == Player.SCISSORS)
            || player1hand == Player.SCISSORS && player2hand == Player.PAPER
            || player1hand == Player.PAPER && player2hand == Player.STONE)
                winner = player1
        //プレーヤー2が勝つ場合
        else if((player1hand == Player.PAPER && player2hand == Player.SCISSORS)
                || player1hand == Player.STONE && player2hand == Player.PAPER
                || (player1hand == Player.SCISSORS && player2hand == Player.STONE))
            winner = player2
        //どちらでもない場合はnull（引き合わせ）
        return winner
    }

    /**
     * 最終的な勝者を決定する
     */
    private fun judgeFinalWinner(player1: Player, player2: Player):Player?{
        var winner:Player? = null

        val player1WinCount = player1.getWinCount()
        val player2WinCount = player2.getWinCount()

        if(player1WinCount > player2WinCount)
            winner = player1
        else if (player2WinCount > player1WinCount)
            winner = player2

        return winner
    }


    /**
     * ジャンケンの手を表示する
     * @param hand ジャンケンの手
     */
    private fun printHand(hand:Int){
        var msg:String = "エラー"
        when(hand){
            Player.STONE -> msg = "グー"
            Player.SCISSORS -> msg = "チョキ"
            Player.PAPER -> msg = "パー"
        }
        print(msg)
    }
}