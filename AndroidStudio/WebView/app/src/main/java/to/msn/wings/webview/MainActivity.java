package to.msn.wings.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        //ボタンクリック時の操作
    public void btn_onClick(View view){
        WebView webView = findViewById(R.id.webView);
            //クリックされたボタンに応じて、決められたページを読み込む
        switch (view.getId()){
            case R.id.btnHome:
                webView.loadUrl("https://www.amazon.com/");
                break;
        }
    }
}
