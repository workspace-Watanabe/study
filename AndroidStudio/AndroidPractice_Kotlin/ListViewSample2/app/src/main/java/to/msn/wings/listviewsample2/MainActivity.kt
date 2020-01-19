package to.msn.wings.listviewsample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            //ListViewオブジェクトを取得
        val lvMenu:ListView = findViewById(R.id.lvMenu)
            //リストに表示するデータを作成
        var menuList:MutableList<String> = mutableListOf("唐揚げ定食","ハンバーグ定食",
            "生姜焼き定食","ステーキ定食","野菜炒め定食","とんかつ定食","ミンチカツ定食",
            "チキンカツ定食","コロッケ定食","焼き魚定食","焼肉定食")
            //アダプタオブジェクトを生成
        val adapter :ArrayAdapter<String> = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,
            menuList)

            //リストビューにアダプタを設定
        lvMenu.adapter = adapter
            //リストビューにリスナーを登録
        lvMenu.onItemClickListener = ListItemClickListener()
    }
        //リストがタップされた時の処理が記述されたメンバクラス。
    private inner class ListItemClickListener : AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                    //注文確認ダイアログフラグメントを生成。
                val dialogFragment:OrderConfirmDialogFragment = OrderConfirmDialogFragment()
                    //ダイアログ表示
                dialogFragment.show(supportFragmentManager,"OrderConfirmDialogFragment")
            }
        }

}
