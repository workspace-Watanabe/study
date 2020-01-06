package to.msn.wings.alertdialogsample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialogFlagment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            //ダイアログの生成
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            //ダイアログの設定
        Dialog dialog  =builder.setTitle(R.string.text).setMessage("こんにちは、世界！").create();
        return dialog;
    }
}
