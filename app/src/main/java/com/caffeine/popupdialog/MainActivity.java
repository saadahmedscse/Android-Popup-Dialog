package com.caffeine.popupdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;

//import com.saadahmedsoft.popupdialog.PopupDialog;
//import com.saadahmedsoft.popupdialog.Styles;
//import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        PopupDialog.getInstance(this)
//                .setStyle(Styles.STANDARD)
//                .setHeading("This is heading")
//                .setDescription("This is the description")
//                .setDismissButtonText("Close")
//                .showDialog(new OnDialogButtonClickListener() {
//                    @Override
//                    public void onDismissClicked(Dialog dialog) {
//                        dialog.dismiss();
//                    }
//                });
    }
}