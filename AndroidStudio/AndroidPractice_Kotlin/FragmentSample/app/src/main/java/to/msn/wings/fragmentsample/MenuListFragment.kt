package to.msn.wings.fragmentsample


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter

/**
 * A simple [Fragment] subclass.
 */
class MenuListFragment : Fragment() {

    private var isLayoutXLarge = true

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
            //menuThanksFrameを取得する
        val menuThanksFrame = activity?.findViewById<View>(R.id.menuThanksFrame)
            //menuThanksFrameがNULLなら...(タブレットではない)
        if(menuThanksFrame == null){
            isLayoutXLarge = false
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_menu_list,container,false)

        val lvMenu = view.findViewById<ListView>(R.id.lvMenu)
            //SimpleAdapterで使用するMutableListオブジェクトを用意。
        var menuList:MutableList<MutableMap<String,String>> = mutableListOf()
        menuList = createTeshokuList()

            //SimpleAdapter第４引数from用データ
        val from = arrayOf("name","price")
        val to = intArrayOf(android.R.id.text1,android.R.id.text2)

        val adapter = SimpleAdapter(activity,menuList,android.R.layout.simple_list_item_2,from,to)
        lvMenu.adapter = adapter
        lvMenu.onItemClickListener = ListItemClickListener()
        return view
    }

    private fun createTeshokuList(): MutableList<MutableMap<String, String>> {
        //定食メニュー用のリストオブジェクト
        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()

        //唐揚げ定食のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        var menu = mutableMapOf("name" to "唐揚げ定食", "price" to "800")
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
        menu = mutableMapOf("name" to "ミンチカツ定食", "price" to "850")
        menuList.add(menu)
        menu = mutableMapOf("name" to "コロッケ定食 ", "price" to "850")
        menuList.add(menu)
        menu = mutableMapOf("name" to "焼き魚定食", "price" to "850")
        menuList.add(menu)
        return menuList
    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val item = parent?.getItemAtPosition(position) as MutableMap<String,String>

            val menuName = item["name"]
            val menuPrice = item["price"]
                //引き継ぎデータをまとめて格納できるBundleオブジェクトを生成
            val bundle = Bundle()

            bundle.putString("menuName", menuName)
            bundle.putString("menuPrice", menuPrice)

                //大画面の場合
            if(isLayoutXLarge){
                    //フラグメントトランザクションの開始
                val transaction = fragmentManager?.beginTransaction()
                    //注文完了フラグメントを生成
                val menuThanksFragment = MenuThanksFragment()
                    //引き継ぎデータを注文完了フラグメントに格納。
                menuThanksFragment.arguments = bundle
                    //生成した注文完了フラグメントをmenuThanksFrameレイアウト部品に追加（置き換え）。
                transaction?.replace(R.id.menuThanksFrame,menuThanksFragment)
                transaction?.commit()
            }else{
                    //インテントオブジェクトを生成。
                val intent = Intent(activity,MenuThnaksActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }

        }
    }



}
