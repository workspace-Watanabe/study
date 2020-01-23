package to.msn.wings.intentsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {

    private var menuList:MutableList<MutableMap<String,Any>>? = null

    private val FROM = arrayOf("name", "price")

    private val TO = intArrayOf(R.id.tvMenuName, R.id.tvMenuPrice)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            //画面部品ListViewを取得
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
            //SimpleAdapterで使用するMutableListオブジェクトを生成
        this.menuList = createTeshokuList()

            //SimpleAdapter第５引数to用データの用意
        val adapter = SimpleAdapter(applicationContext,this.menuList,R.layout.row,FROM,TO)

        lvMenu.adapter = adapter

            //リストタップのリストクラス
        lvMenu.onItemClickListener = ListItemClickListener()

    }

        //リストがタップされた時の処理が記述されたメンバクラス
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //タップされた行を取得
                val item = parent!!.getItemAtPosition(position) as MutableMap<String, Any>
                //定食名と金額を取得
                val menuName: String? = item["name"] as String
                val menuPrice = item["price"] as Int
                //インテントオブジェクトを生成
                val intent = Intent(applicationContext, MenuThanksActivity::class.java)
                //第２画面に送るデータを格納
                intent.putExtra("menuName", menuName)
                intent.putExtra("menuPrice", menuPrice.toString())
                //第２画面の起動
                startActivity(intent)

            }
        }

            private fun createTeshokuList(): MutableList<MutableMap<String, Any>> {
                //定食メニュー用のリストオブジェクト
                val menuList: MutableList<MutableMap<String, Any>> = mutableListOf()

                //唐揚げ定食のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
                var menu = mutableMapOf<String, Any>("name" to "唐揚げ定食", "price" to "800")
                menuList.add(menu)
                menu = mutableMapOf("name" to "ハンバーグ定食", "price" to "850")
                menuList.add(menu)
                menu = mutableMapOf("name" to "生姜焼き定食", "price" to "850")
                menuList.add(menu)
                menu = mutableMapOf("name" to "ステーキ定食", "price" to "850")
                menuList.add(menu)
                menu = mutableMapOf("name" to "野菜炒め定食", "price" to "850")
                menuList.add(menu)
                menu = mutableMapOf("name" to "とんかつ定食", "price" to "850")
                menuList.add(menu)
                menu = mutableMapOf("name" to "ミンチカツ定食", "price" to "850円")
                menuList.add(menu)
                menu = mutableMapOf("name" to "コロッケ定食 ", "price" to "850")
                menuList.add(menu)
                menu = mutableMapOf("name" to "焼き魚定食", "price" to "850")
                menuList.add(menu)
                return menuList
            }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }


}
