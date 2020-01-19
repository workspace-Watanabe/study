package to.msn.wings.listviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import java.io.StringBufferInputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            //ListViewオブジェクトを取得
        val lvMenu : ListView = findViewById(R.id.lvMenu)
            //ListViewにリスナを設定
        lvMenu.onItemClickListener  = ListItemClickListener()
    }

    /**
     * リストがタップされた時のリスナクラス
     */
    private inner class ListItemClickListener : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
             //タップされた時の定食名を取得
            val item  = parent!!.getItemAtPosition(position) as String
                //トーストで表示する文字列を生成
            val show = "あなたが選んだ定食 : ${item}"
                //トーストの表示
            Toast.makeText(applicationContext,show,Toast.LENGTH_LONG).show()
        }
    }
}
