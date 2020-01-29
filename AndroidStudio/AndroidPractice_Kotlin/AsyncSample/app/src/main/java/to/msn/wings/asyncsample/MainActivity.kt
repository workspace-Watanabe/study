package to.msn.wings.asyncsample

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.nio.Buffer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //画面部品ListViewを取得
        val lvCityList = findViewById<ListView>(R.id.lvCityList)
        //SimpleAdapterで使用するMutableMapオブジェクトの用意とcityListへのデータ登録
        val cityList:MutableList<MutableMap<String,String>> = mutableListOf()
        //都市データを格納するMutableMapの用意
         var city = mutableMapOf("name" to "大阪", "id" to "270000")
        cityList.add(city)
         city = mutableMapOf("name" to "神戸", "id" to "280010")
        cityList.add(city)
        city = mutableMapOf("name" to "豊岡", "id" to "280020")
        cityList.add(city)
        city = mutableMapOf("name" to "京都", "id" to "260010")
        cityList.add(city)
        city = mutableMapOf("name" to "舞鶴", "id" to "260020")
        cityList.add(city)

        //SimpleAdapterで使用するfrom-to変数の用意
        val from = arrayOf("name")
        val to = intArrayOf(android.R.id.text1)
        //SimpleAdapterを生成。
        val adapter = SimpleAdapter(applicationContext,cityList,android.R.layout.simple_expandable_list_item_1,from, to)

        lvCityList.adapter = adapter
        lvCityList.onItemClickListener = ListItemClickListener()

    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val item = parent?.getItemAtPosition(position) as Map<String,String>
            //タップされた都市名と都市IDを取得。
            val cityName = item["name"]
            val cityId = item["id"]


            //取得した都市名をtvCityNameに設定。
            val tvCityName = findViewById<TextView>(R.id.tvCityName)
            tvCityName.setText("${cityName}の天気")
            //WeatherInfoRecevierインスタンスを生成。
            val recevier = WeatherInfoRecevier()
            recevier.execute(cityId)
        }
    }

    private inner class WeatherInfoRecevier() : AsyncTask<String,String,String>(){
        override fun doInBackground(vararg params: String?): String {
            //可変長引数の１個目を取得　これがとしID
            val id = params[0]
            val urlStr = "http://weather.livedoor.com/forecast/webservice/json/v1?city=${id}"

            //URLオブジェクトを生成
            val url = URL(urlStr)
            //URLオブジェクトからHttpURLConnectionオブジェクトを生成
            val con: HttpURLConnection = url.openConnection() as HttpURLConnection
            //http接続メソッドを設定
            con.requestMethod = "GET"
            //接続
            con.connect()
            //HttpURLConnectionオブジェクトからレスポンスデータを取得。天気情報が格納されている。
            val stream = con.inputStream
            //レスポンスデータであるInputStreamを文字列に変換
            val result = is2String(stream)

            con.disconnect()
            stream.close()
            return result
        }

        override fun onPostExecute(result: String) {

            //JSON文字列からJSONObjectを生成
            val rootJSON = JSONObject(result)
            val descriptionJSON = rootJSON.getJSONObject("description")
            //[description]直下の[text]文字列を取得。
            val desc = descriptionJSON.getString("text")
            //ルートJSON直下の[forecast]JSON配列を取得。
            val forecasts = rootJSON.getJSONArray("forecasts")
            val forecastNow = forecasts.getJSONObject(0)
            val telop = forecastNow.getString("telop")

            val tvWeatherTelop = findViewById<TextView>(R.id.tvWeatheTelop)
            val tvWeatherDesc = findViewById<TextView>(R.id.tvWeatherDesc)
            tvWeatherTelop.text = telop
            tvWeatherDesc.text = desc
        }

        private fun is2String(stream:InputStream) : String{
            val sb = StringBuilder()
            val reader = BufferedReader(InputStreamReader(stream,"UTF-8"))
            var line = reader.readLine()
            while(line != null){
                sb.append(line)
                line = reader.readLine()
            }
            reader.close()
            return sb.toString()
        }
    }
}
