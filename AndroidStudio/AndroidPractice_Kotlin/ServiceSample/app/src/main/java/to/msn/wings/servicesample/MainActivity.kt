package to.msn.wings.servicesample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onPlayButtonClick(view:View){
        //インテントを生成
        val intent = Intent(applicationContext,SoundManageService::class.java)
        //サービスを起動
        startService(intent)

        val btPlay = findViewById<Button>(R.id.btPlay)
        val btStop = findViewById<Button>(R.id.btStop)
        btPlay.isEnabled = false
        btStop.isEnabled = true
    }

    fun onStopButtonClick(view:View){
        val intent = Intent(applicationContext,SoundManageService::class.java)
        stopService(intent)

        val btPlay = findViewById<Button>(R.id.btPlay)
        val btStop = findViewById<Button>(R.id.btStop)
        btPlay.isEnabled = true
        btStop.isEnabled = false
    }
}
