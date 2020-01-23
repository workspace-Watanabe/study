package to.msn.wings.menusample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast

class MainActivity : AppCompatActivity() {
        //リストびゅうーに表示するリストデータ
    private var menuList: MutableList<MutableMap<String,Any>>? = null
        //SimpleAdapterの第4引数fromに使用する定数フィールド
    private val FROM = arrayOf("name", "price")
        //SimpleAdapterの第5引数toに使用する定数フィールド
    private val TO = intArrayOf(R.id.tvMenuName,R.id.tvMenuPrice)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuList = createTeishokuList()
        val LVMENU = findViewById<ListView>(R.id.lvMenu)
        val ADAPTER = SimpleAdapter(applicationContext,menuList,R.layout.row,FROM,TO)
        LVMENU.adapter = ADAPTER
        LVMENU.onItemClickListener = ListItemClickListener()

        registerForContextMenu(LVMENU)
    }

    private fun createTeishokuList() : MutableList<MutableMap<String,Any>>{
            //定食メニュー用のListオブジェクトを用意
        val menuList = mutableListOf<MutableMap<String,Any>>()
            //データの登録
        var menu = mutableMapOf<String,Any>("name" to "唐揚げ定食", "price" to 800, "desc" to "若鳥の唐揚げにサラダ、ご飯とみそ汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 850, "desc" to "手ごねハンバーグにサラダ、ご飯とみそ汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "生姜焼き定食", "price" to 850, "desc" to "若鳥の唐揚げにサラダ、ご飯とみそ汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ステーキ定食", "price" to 1000, "desc" to "手ごねハンバーグにサラダ、ご飯とみそ汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "野菜炒め定食", "price" to 750, "desc" to "若鳥の唐揚げにサラダ、ご飯とみそ汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "とんかつ定食", "price" to 900, "desc" to "手ごねハンバーグにサラダ、ご飯とみそ汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ミンチカツ定食", "price" to 850, "desc" to "若鳥の唐揚げにサラダ、ご飯とみそ汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "コロッケ定食", "price" to 850, "desc" to "手ごねハンバーグにサラダ、ご飯とみそ汁が付きます。")
        menuList.add(menu)

        return menuList
    }

    private fun createCurryList() : MutableList<MutableMap<String,Any>>{
        //定食メニュー用のListオブジェクトを用意
        val menuList = mutableListOf<MutableMap<String,Any>>()
        //データの登録
        var menu = mutableMapOf("name" to "ビーフカレー", "price" to 500, "desc" to "若鳥の唐揚げにサラダ、ご飯とみそ汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ポークカレー", "price" to 600, "desc" to "手ごねハンバーグにサラダ、ご飯とみそ汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ハンバーグカレー", "price" to 850, "desc" to "若鳥の唐揚げにサラダ、ご飯とみそ汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "チーズカレー", "price" to 1000, "desc" to "手ごねハンバーグにサラダ、ご飯とみそ汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "カツカレー", "price" to 750, "desc" to "若鳥の唐揚げにサラダ、ご飯とみそ汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ビーフカレー", "price" to 900, "desc" to "手ごねハンバーグにサラダ、ご飯とみそ汁が付きます。")
        menuList.add(menu)
        menu = mutableMapOf("name" to "唐揚げカレー", "price" to 850, "desc" to "若鳥の唐揚げにサラダ、ご飯とみそ汁が付きます。")
        menuList.add(menu)


        return menuList
    }

    /**
     * 注文処理を行うメソッド
     */
    private fun order(menu: MutableMap<String,Any>){
        //定食名と金額を取得。
        val MENUNAME = menu["name"] as String
        val MENUPRICE = menu["price"] as Int
        //インテントオブジェクトを生成。
        val INTENT = Intent(applicationContext,MenuThanksActivity::class.java)

        INTENT.putExtra("menuName",MENUNAME)
        INTENT.putExtra("menuPrice","${MENUPRICE}円")

        startActivity(INTENT)
    }

    /**
     * クリックリスナークラス
     */
    private inner class ListItemClickListener : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //タップされた行を取得
            val item = parent?.getItemAtPosition(position) as MutableMap<String,Any>
                //注文処理を行う
            order(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options_menu_list,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            //選択されたメニューのIDのR値による処理の分岐
        when(item.itemId){
            R.id.menuListOptionTeishoku -> menuList = createTeishokuList()
            R.id.menuListOptionCurry    -> menuList = createCurryList()
        }
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        val adapter = SimpleAdapter(applicationContext,menuList, R.layout.row, FROM, TO)
        lvMenu.adapter = adapter
        return super.onOptionsItemSelected(item)
    }

    /**
     * コンテキストメニューを生成
     */
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
            //コンテキストメニュー用xmlファイルをインフレイト
        menuInflater.inflate(R.menu.menu_context_menu_list,menu)
        menu?.setHeaderTitle(R.string.menu_list_context_header)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
            //長押しされたリストのポジションを取得
        val listPosition = info.position
            //ポジションから長押しされたメニュー情報Mapオブジェクトを取得
        val menu = menuList!![listPosition]

            //選択されたメニューのIDのR値による処理の分岐
        when(item.itemId){
            R.id.menuListContextDesc -> {
                val desc = menu["desc"] as String
                    //トーストの表示
                Toast.makeText(applicationContext,desc,Toast.LENGTH_LONG).show()
            }

                //[ご注文]メニューが選択された時の処理
            R.id.menuListCOntextOrder -> order(menu)
        }
        return super.onContextItemSelected(item)
    }



}
