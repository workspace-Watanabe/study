package to.msn.wings.simpleadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //リストに表示するデータを準備
        String[] titles = {"革命のエチュード","G線上のアリア","シャコンヌ","夜の女王のアリア","春の海"};
        String[] tags = {"ピアノ","バイオリン","チェロ","声楽","箏"};
        String[] details = {"detail1","detail2","detail3","detail4","detail5"};

            //配列の内容をHashMapに詰め替え
        ArrayList<HashMap<String,String>> data = new ArrayList<>();
        for(int i=0; i<titles.length;i++){
            HashMap<String,String> item = new HashMap<>();
            item.put("title",titles[i]);
            item.put("tag",tags[i]);
            item.put("detail",details[i]);
            data.add(item);
        }
            //HashMap配列とレイアウトを関連付け
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data,R.layout.list_item,
                new String[]{"title","tag","detail"},
                new int[]{R.id.title,R.id.tag,R.id.detail});

            //アダプターをもとにリストを生成
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(simpleAdapter);
    }
}
