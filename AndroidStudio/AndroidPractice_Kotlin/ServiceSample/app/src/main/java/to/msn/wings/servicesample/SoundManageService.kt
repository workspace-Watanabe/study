package to.msn.wings.servicesample

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import java.io.IOException
import java.lang.IllegalArgumentException

class SoundManageService : Service() {

    private var player : MediaPlayer? = null
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        player = MediaPlayer()
        //通知チャネルのID文字列を用意。
        val id = "soundmanagerservice_notification_channel"
        //通知チャネル名をstring.xmlから取得
        val name = getString(R.string.notification_channel_name)
        //通知チャネルの重要度を標準に設定
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(id,name,importance)
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val mediaFileUriStr = "android.resource://${packageName}/${R.raw.mountain_stream}"
        //URIオブジェクトを生成
        val mediaFileUri = Uri.parse(mediaFileUriStr)

        try{
            //メディアプレイヤーに音声ファイルを指定
            player?.setDataSource(applicationContext,mediaFileUri)
            //非同期でのメディア再生準備が完了した際のリスナを設定
            player?.setOnPreparedListener(PlayPreparedListener())
            //メディア再生が終了したときのリスナ
            player?.setOnCompletionListener(PlayerCompletionListener())
            //非同期でメディア再生を準備
            player?.prepareAsync()

        }catch (ex : IllegalArgumentException){
            Log.e("ServiceSample", "メディアプレーヤー準備時の例外発生",ex)
        }catch (ex : IOException){
            Log.e("ServiceSample", "メディアプレーヤー準備時の例外発生",ex)
        }
        return START_NOT_STICKY
    }



    override fun onDestroy() {
        player?.let {
            if(it.isPlaying){
                it.stop()
            }
            it.release()
            player = null
        }
    }

    /**
     * メディア再生準備が完了時のリスナクラス
     */
    private inner class PlayPreparedListener : MediaPlayer.OnPreparedListener{
        override fun onPrepared(mp: MediaPlayer?) {
            mp?.start()
        }
    }

    /**
     * メディア再生が終了したときのリスナクラス
     */
    private inner class PlayerCompletionListener : MediaPlayer.OnCompletionListener{
        override fun onCompletion(mp: MediaPlayer?) {
            val builder = NotificationCompat.Builder(applicationContext,"soundmanagerservice_notification_channel")
            builder.setSmallIcon(android.R.drawable.ic_dialog_info)
            builder.setContentTitle(getString(R.string.msg_notification_title_finish))
            builder.setContentText(getString(R.string.msg_notification_text_finish))
            val notification = builder.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(0,notification)
            stopSelf()
        }
    }
}
