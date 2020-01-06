package to.msn.wings.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import org.w3c.dom.Text;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnCurrent_onClick(View view){
        TextView txt = findViewById(R.id.textResult);
        txt.setText(new Date().toString());
        Log.v("CurrentTime", new Date().toString());
    }




    //画面が破棄される前に状態を保存
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        TextView txtResult = findViewById(R.id.textResult);
        outState.putString("txtResult",txtResult.getText().toString());
    }

    //画面が復元される際に状態を取り出し
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
            //テキストオブジェクトを取得
        TextView txtResult = findViewById(R.id.textResult);
            //破棄される前の状態をセットする
        txtResult.setText(savedInstanceState.getString("txtResult"));
    }

}
