package to.msn.wings.listbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            //リスト項目をArrayListとして準備
        final ArrayList<String> data = new ArrayList<>();

            data.add("sampleText");
            data.add("ターメリック");
            data.add("コリアンダー");
            data.add("生姜");
            data.add("ニンニク");
            data.add("サフラン");

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
            //フィルター機能を有効か
        listView.setTextFilterEnabled(true);

        listView.setOnScrollListener(
                new AbsListView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(AbsListView view, int scrollState) {

                    }

                    @Override
                    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                        if(firstVisibleItem + visibleItemCount + 1 > totalItemCount){
                            adapter.add("新胡椒");
                            adapter.add("新　ターメリック");
                            adapter.add("新　コリアンダー");
                        }
                    }
                }
        );
            //検索ボックスに入力された時の処理を定義
        SearchView searchView = findViewById(R.id.search);
        searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                       if(newText == null || newText.equals(""))
                           listView.clearTextFilter();
                       else {
                           listView.setFilterText(newText);
                       }
                       return false;
                    }
                }
        );



    }
}
