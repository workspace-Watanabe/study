package to.msn.wings.fragmentsample


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 */
class MenuThanksFragment : Fragment() {

    private var isLayoutXLarge = true
    /**
     * 大画面かどうかの判定フラグ
     * trueが大画面
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val menuListFragment = fragmentManager?.findFragmentById(R.id.fragmentMenuList)

        if(menuListFragment == null){
            isLayoutXLarge = false
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            //フラグメントで表示する画面をXMLファイルからインフレーとする
        val view = inflater.inflate(R.layout.fragment_menu_thanks,container,false)

        val extras: Bundle?
        if(isLayoutXLarge){
            extras = arguments
        }else{
            val intent = activity?.intent
            extras = intent?.extras
        }
            //定食名と金額を取得
        val menuName = extras?.getString("menuName")
        val menuPrice = extras?.getString("menuPrice")
            //定食名と金額を表示させるTextViewを取得
        val tvMenuName = view.findViewById<TextView>(R.id.tvMenuName)
        val tvMenuPrice = view.findViewById<TextView>(R.id.tvMenuPrice)
            //TextViewに定食名と金額を表示
        tvMenuName.text = menuName
        tvMenuPrice.text = menuPrice

        val btBackButton = view.findViewById<Button>(R.id.btBackButton)
        btBackButton.setOnClickListener(ButtonClickListener())

        return view
    }

    private  inner class ButtonClickListener : View.OnClickListener{
        override fun onClick(v: View?) {
           if(isLayoutXLarge){
               val transaction = fragmentManager?.beginTransaction()
               transaction?.remove(this@MenuThanksFragment)
               transaction?.commit()
           }else
               activity?.finish()
        }
    }


}
