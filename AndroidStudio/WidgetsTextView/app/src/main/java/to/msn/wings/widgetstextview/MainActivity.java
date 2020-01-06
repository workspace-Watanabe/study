package to.msn.wings.widgetstextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        //ボタンクリック時にメッセージを表示
    public void btnSend_onClick(View view){
        EditText txtName = findViewById(R.id.txtName);
        TextView txtResult = findViewById(R.id.txtResult);
        txtResult.setText(String.format("こんにちは、%sさん！",txtName.getText()));
        
    }
}
