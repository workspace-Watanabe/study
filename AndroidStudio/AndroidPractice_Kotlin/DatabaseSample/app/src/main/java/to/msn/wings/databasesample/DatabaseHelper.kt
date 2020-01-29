package to.msn.wings.databasesample

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.StringBuilder

class DatabaseHelper(context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {
        //staticメンバ
    companion object{
                //データベースファイル名
            private const val DATABASE_NAME = "cocktailmemo.db"
                //バージョン情報の定数フィールド
            private const val DATABASE_VERSION = 1
        }

    override fun onCreate(db: SQLiteDatabase?) {
            //テーブル作成用SQL文字列の作成
        val sb = StringBuilder()
        sb.append("CREATE TABLE cocktailmemos (")
        sb.append("_id INTEGER PRIMARY KEY,")
        sb.append("name TEXT,")
        sb.append("note TEXT")
        sb.append(");")
        val sql = sb.toString()

            //SQLの実行。
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}