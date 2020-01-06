package to.msn.wings.widgetscheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            createSpinner();
        //レーティングバーを取得
        RatingBar rating = findViewById(R.id.rating);
        rating.setOnRatingBarChangeListener((RatingBar rate, float ratingBar, boolean fromUser)->{
            Toast.makeText(this,
                    String.format(Locale.JAPAN,"現在の評価は%fです",ratingBar),
                    Toast.LENGTH_SHORT).show();
        });

    }

    public void createSpinner(){
        ArrayList<String> list = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.JAPAN);
        Calendar cal = Calendar.getInstance();
        //明日～10日後の日付リストを生成
        for(int i=0; i < 11; i++){
            cal.set(Calendar.DAY_OF_MONTH,cal.get(Calendar.DAY_OF_MONTH)+1);
            list.add(format.format(cal.getTime()));
        }

        //配列をウィジェットに渡す準備
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,list);
        Spinner spinner = findViewById(R.id.spnArch);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spin = (Spinner) parent;
                Toast.makeText(MainActivity.this,
                        String.format("選択項目:%s",spin.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}
