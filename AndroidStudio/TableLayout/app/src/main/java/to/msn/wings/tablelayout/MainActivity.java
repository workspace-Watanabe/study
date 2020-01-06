package to.msn.wings.tablelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    private boolean flg = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        //表示/非表示ボタンで列を開閉
    public void btnFlag_onClick(View view){
        TableLayout tableColumn1 = findViewById(R.id.table);
        tableColumn1.setColumnCollapsed(1,flg);
        flg = !flg;
    }
}
