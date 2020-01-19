package to.msn.wings.hellosample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            //リスナクラスのインスタンスを取得
        val listener : HelloListener = HelloListener()

            //[表示]ボタン
        val btnClick: Button = findViewById(R.id.btnClick)

            //表示ボタンにリスナを設定
        btnClick.setOnClickListener(listener);

            //【削除】ボタン
        val btnClear : Button = findViewById(R.id.btClear)
        btnClear.setOnClickListener(listener)
    }

    private inner class HelloListener : View.OnClickListener{
        override fun onClick(v: View) {
                //名前入力欄であるEditTextオブジェクトを取得
            val input = findViewById<EditText>(R.id.etName);
                //メッセージを表示するTextViewオブジェクトを取得
            val output = findViewById<TextView>(R.id.tvOutput);

                //idのR値に応じて処理を分岐させる
            when(v.id){
                    //表示ボタンの場合...
                R.id.btnClick ->{
                    val inputStr : String = input.text.toString()
                    output.text = "${inputStr} さん、Hello！"
                }
                    //クリアボタンの場合...
                R.id.btClear ->{
                    input.setText("")
                    output.text = ""
                }
            }
        }


    }
}
