package to.msn.wings.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Date;

import android.os.Bundle;
import android.provider.ContactsContract;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Data data = new Data();
    }
}
