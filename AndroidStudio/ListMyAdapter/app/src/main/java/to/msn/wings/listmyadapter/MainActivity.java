package to.msn.wings.listmyadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            //リストに表示するデータを準備
        String[] titles = {"タイトル1", "タイトル2", "タイトル3"};
        String[] tags = {"タグ1", "タグ2", "タグ3"};
        String[] details = {"詳細1", "詳細2", "詳細3"};

            //配列の内容をListItemオブジェクトに詰め替え
        ArrayList<ListItem> listItems = new ArrayList<>();
        for(int i=0; i<titles.length; i++){
            ListItem item = new ListItem();
            item.setTitle(titles[i]);
            item.setTag(tags[i]);
            item.setDetail(details[i]);
            item.setId(new Random().nextLong());
            listItems.add(item);
        }
            //ListItem配列とレイアウトを関連付け
        MyListAdapter adapter = new MyListAdapter(this, listItems, R.layout.list_item);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
