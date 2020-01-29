package to.msn.wings.databasesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    /**
     * 選択されたカクテルの主キーIDを表すフィールド
     */
    private var cocktailId = -1

    /**
     * 選択されたカクテル名を表すフィールド
     */
    private var cocktailName = ""

    /**
     * データベースヘルパーオブジェクト
     */
    private val helper = DatabaseHelper(this@MainActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            //カクテル用ListView(lvCocktail)を取得
        val lvCocktail = findViewById<ListView>(R.id.lvCocktail)
            //lvCocktailにリスナを登録
        lvCocktail.onItemClickListener = ListItemClickListener()
    }

    /**
     * 保存ボタンがタップされた時の処理メソッド
     */
    fun onSaveButtonClick(view:View) {
        //感想欄を取得
        val etNote = findViewById<EditText>(R.id.etNote)

        // -------------------- データベース接続 --------------------
            //入力された感想を取得
        val note = etNote.text.toString()
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得。
        val db = helper.writableDatabase

            //まず、リストで選択されたカクテルのメモデータを削除。
        val sqlDelete = "DELETE FROM cocktailmemos WHERE _id=?"
        var stmt = db.compileStatement(sqlDelete)
        stmt.bindLong(1,cocktailId.toLong())
        stmt.executeUpdateDelete()


                //次にインサート用文字列の用意
                val sqlInsert = "INSERT INTO cocktailmemos (_id, name, note) VALUES (?, ?, ?)"
                stmt = db.compileStatement(sqlInsert)
                stmt.bindLong(1,cocktailId.toLong())
                stmt.bindString(2,cocktailName)
                stmt.bindString(3,note)
                stmt.executeInsert()


        // ----------------------------------------------------------------------------------//



        //感想欄の入力値を消去
        etNote.setText("")
        //カクテルを表示するTextViewを取得
        val tvCocktailName = findViewById<TextView>(R.id.tvCocktailName)
        //カクテル名を未選択に変更
        tvCocktailName.text = getString(R.string.tv_name)
        //保存ボタンを取得
        val btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.isEnabled = false
    }


    /**
     * リストがタップされた時の処理が記述されたメンバクラス
     */
    private inner class ListItemClickListener : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            cocktailId = position
                //タップされた行のデータを取得
            cocktailName = parent?.getItemAtPosition(position) as String
                //カクテル名を表示するTextViewを取得
            val tvCocktailName = findViewById<TextView>(R.id.tvCocktailName)
                //表示カクテル名を設定
            tvCocktailName.text = cocktailName
                //保存ボタンを取得
            val btnSave = findViewById<Button>(R.id.btnSave)
            btnSave.isEnabled = true

            //----------------- データベースから感想を取得し、感想欄に記述
            val db = helper.writableDatabase
            val sql = "SELECT * FROM cocktailmemos WHERE _id = ${cocktailId}"
            val cursor = db.rawQuery(sql,null)
            var note = ""
            while(cursor.moveToNext()){
                val index = cursor.getColumnIndex("note")
                note = cursor.getString(index)
            }
            val etNote = findViewById<EditText>(R.id.etNote)
            etNote.setText(note)
        }
    }

    override fun onDestroy() {
        helper.close()
        super.onDestroy()
    }
}

