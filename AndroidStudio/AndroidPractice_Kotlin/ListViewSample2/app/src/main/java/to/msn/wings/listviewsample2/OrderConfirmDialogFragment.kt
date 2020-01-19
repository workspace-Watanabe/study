package to.msn.wings.listviewsample2

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class OrderConfirmDialogFragment : DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreate(savedInstanceState)

            //ダイアログビルダをを生成
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
            //ダイアログのタイトルを設定
        builder.setTitle(R.string.dialog_title)
            //ダイアログのメッセージを取得
        builder.setMessage(R.string.dialog_msg)
            //Positive Buttonを設定
        builder.setPositiveButton(R.string.dialog_btn_ok,DialogButtonClickListener())
            //Negative Buttonを設定
        builder.setNegativeButton(R.string.dialog_btn_ng,DialogButtonClickListener())
            //Neutral Buttonを設定
        builder.setNeutralButton(R.string.dialog_btn_nu,DialogButtonClickListener())
            //ダイアログオブジェクトを生成し、リターン
        val dialog = builder.create()
        return dialog
    }

    /**
     * ダイアログのアクションボタンがタップされた時の処理が記述されたメンバクラス
     */
    private inner class DialogButtonClickListener : DialogInterface.OnClickListener{
        override fun onClick(dialog: DialogInterface?, which: Int) {
                //トースト表示用メッセージを用意
            var message:String = ""
                //タップされたアクションボタンで分岐。
            when(which){
                    //Postive Buttonならば..
                DialogInterface.BUTTON_POSITIVE -> {
                    message = getString(R.string.dialog_ok_toast)
                }
                    //Negative Buttonならば..
                DialogInterface.BUTTON_NEGATIVE -> {
                    message = getString(R.string.dialog_ng_toast)
                }
                    //Neutral Buttonならば..
                DialogInterface.BUTTON_NEUTRAL -> {
                    message = getString(R.string.dialog_nu_toast)
                }
            }
                //トーストの表示
            Toast.makeText(activity,message,Toast.LENGTH_LONG).show()
        }
    }
}