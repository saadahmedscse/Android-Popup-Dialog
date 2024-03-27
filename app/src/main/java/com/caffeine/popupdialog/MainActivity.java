package com.caffeine.popupdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;

import com.caffeine.popupdialog.databinding.ActivityMainBinding;
import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.listener.StandardDialogActionListener;
import com.saadahmedev.popupdialog.listener.StatusDialogActionListener;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        PopupDialog.getInstance(this)
//                .progressDialogBuilder()
//                .createLottieDialog()
//                .setRawRes(com.saadahmedev.popupdialog.R.raw.warning)
//                .setCancelable(false)
//                .setLottieRepeatCount(2)
//                .build()
//                .show();

        PopupDialog.getInstance(this)
                .standardDialogBuilder()
                .createAlertDialog()
                .setNegativeButtonTextColor(R.color.teal_200)
                .setBackgroundColor(com.saadahmedev.popupdialog.R.color.colorGreen)
                .setBackgroundCornerRadius(50F, 10F, 10F, 50F)
                .setHeading("Logged in successfully!")
                .setDescription("Lorem ")
                .setCancelable(false)
                .build(new StandardDialogActionListener() {
                    @Override
                    public void onPositiveButtonClicked(Dialog dialog) {
                        dialog.dismiss();
                    }

                    @Override
                    public void onNegativeButtonClicked(Dialog dialog) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}
