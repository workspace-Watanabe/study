package to.msn.wings.alertdialogsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }{


        public void btn_onClick(View view){
        DialogFragment dialog = new MyDialogFlagment();
        dialog.show(getSupportFragmentManager(),"dialog_");
    }
}
