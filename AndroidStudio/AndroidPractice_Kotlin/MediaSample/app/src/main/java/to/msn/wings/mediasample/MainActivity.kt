package to.msn.wings.mediasample

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {

    //メディアプレイヤーフィールド
    private var player: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            //メディアプレーヤーオブジェクトを生成
        player = MediaPlayer()
        //音声ファイルのURI文字列を作成
        val mediaUriStr = "android.resource://${packageName}/${R.raw.mountain_stream}"
        //URIオブジェクトを生成
        val mediFileUri = Uri.parse(mediaUriStr)
        try{
            //メディアプレイヤーに音声ファイルを指定。
            player?.setDataSource(applicationContext,mediFileUri)
            //非同期でのメディア再生準備が完了した際のリスナを設定
            player?.setOnPreparedListener(PlayerPreparedListener())
            //メディア再生が終了したときのリスナを設定
            player?.setOnCompletionListener (PlayerCompletionListener())
            player?.prepareAsync()
        }catch (ex : IllegalArgumentException){
            Log.e("MediaSample", "例外発生",ex)
        }catch (ex: IOException){
            ex.printStackTrace()
        }
        val loopSwicth = findViewById<Switch>(R.id.swLoop)
        loopSwicth.setOnCheckedChangeListener(LoopSwicthChangedListener())

    }

    fun onPlayButtonClick(view:View){
        player?.let {
            //再生ボタンを取得
            val btPlay = findViewById<Button>(R.id.btPlay)
            if(it.isPlaying){
                it.pause()
                btPlay.setText(R.string.bt_play_play)
            }else{
                it.start()
                btPlay.setText(R.string.bt_play_pause)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.let {
            if(it.isPlaying){
                it.stop()
            }
            it.release()
            player = null
        }
    }

    private inner class PlayerPreparedListener : MediaPlayer.OnPreparedListener{
        override fun onPrepared(mp: MediaPlayer?) {
            val btPlay = findViewById<Button>(R.id.btPlay)
            btPlay.isEnabled = true
            val btBack = findViewById<Button>(R.id.btBack)
            btBack.isEnabled = true
            val btForward = findViewById<Button>(R.id.btForward)
            btForward.isEnabled = true
        }
    }

    private inner class PlayerCompletionListener : MediaPlayer.OnCompletionListener{
        override fun onCompletion(mp: MediaPlayer?) {
            //再生ボタンのラベルを再生に設定
            val btPlay = findViewById<Button>(R.id.btPlay)
            btPlay.setText(R.string.bt_play_play)
        }
    }

    fun onBackButtonClick(view:View){
        player?.seekTo(0)
    }

    fun onForwardButtonClick(view:View){
        player?.let{
            val duration = it.duration
            it.seekTo(duration)
            if(!it.isPlaying){
                it.start()
            }
        }
    }

    private inner class LoopSwicthChangedListener : CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            player?.isLooping = isChecked
        }
    }

}
