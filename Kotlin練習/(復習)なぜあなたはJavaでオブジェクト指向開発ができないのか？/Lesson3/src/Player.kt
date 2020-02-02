/**
 * ジャンケンのプレイヤーを表すクラス
 */
class Player(val name:String) {

    companion object{
        //---------------- ジャンケンの手を表す定数 ----------------------------//
        //グー
         const val STONE = 0
        //チョキ
         const val SCISSORS = 1
        //パー
         const val PAPER = 2
        // --------------------------------------------------------------------//
    }

    /** プレーヤーの勝った回数 */
    private var winCount = 0

    /******************************************************************************************/

    /**
     * ジャンケンの手を出す
     *
     * @return ジャンケンの手
     */
    fun showHand(): Int{
        var hand = 0
        val randomNum:Double = Math.random() * 3.0
        when{
            randomNum < 1 -> hand = STONE
            randomNum < 2 -> hand = SCISSORS
            else -> hand = PAPER
        }
        return hand
    }

    /**
     * 審判から勝敗を聞く
     */
    fun notifyResult(result:Boolean){
        if(result)
            ++winCount
    }

    /**
     * 自分の勝った回数を答える。
     * @return 勝った回数
     */
    fun getWinCount():Int{
        return winCount
    }

}