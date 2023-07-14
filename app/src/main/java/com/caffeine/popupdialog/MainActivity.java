package com.caffeine.popupdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;

import com.caffeine.popupdialog.databinding.ActivityMainBinding;
import com.saadahmedsoft.popupdialog.PopupDialog;
import com.saadahmedsoft.popupdialog.Styles;
import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        PopupDialog.getInstance(this)
//                .setStyle(Styles.PROGRESS)
//                .setHeading("This is heading")
//                .setLottieRepeatCount(0)
//                .setDescription("This is the description")
//                .setDismissButtonText("Close")
//                .showDialog();

        setClickListener();

    }

    private void setClickListener(){
        binding.buttonProgress.setOnClickListener(view ->showMyDialog(Styles.PROGRESS));
        binding.buttonIos.setOnClickListener(view -> showMyDialog(Styles.IOS));
        binding.buttonDefault.setOnClickListener(view -> {
            PopupDialog.getInstance(this)
                    .setStyle(Styles.ANDROID_DEFAULT)
                    .setHeading("Logout")
                    .setDescription("Are you sure you want to logout?"+
                            " This action cannot be undone")
                    .setCancelable(false)
                    .showDialog(new OnDialogButtonClickListener() {
                        @Override
                        public void onPositiveClicked(Dialog dialog) {
                            super.onPositiveClicked(dialog);
                        }

                        @Override
                        public void onNegativeClicked(Dialog dialog) {
                            super.onNegativeClicked(dialog);
                        }
                    });
            //showMyDialog(Styles.ANDROID_DEFAULT)
        });
        binding.buttonStandard.setOnClickListener(view -> {
            showMyDialog(Styles.STANDARD);
        });
        binding.buttonLottie.setOnClickListener(view -> showMyDialog(Styles.LOTTIE_ANIMATION));
        binding.buttonSuccess.setOnClickListener(view -> {
            PopupDialog.getInstance(this)
                    .setStyle(Styles.SUCCESS)
                    .setHeading("Well Done")
                    .setDescription("You have successfully"+
                            " completed the task")
                    .setCancelable(false)
                    .showDialog(new OnDialogButtonClickListener() {
                        @Override
                        public void onDismissClicked(Dialog dialog) {
                            super.onDismissClicked(dialog);
                        }
                    });
            //showMyDialog(Styles.SUCCESS)
        });
        binding.buttonFailed.setOnClickListener(view -> showMyDialog(Styles.FAILED));
        binding.buttonAlert.setOnClickListener(view -> showMyDialog(Styles.ALERT));

    }

    private void showMyDialog(Styles style){
        PopupDialog popupDialog = PopupDialog.getInstance(this);

        if(style == Styles.PROGRESS || style == Styles.LOTTIE_ANIMATION){
            popupDialog.setStyle(style)
                    .setHeading("This is heading")
                    .setLottieRepeatCount(0)
                    .setDescription("This is the description")
                    .setDismissButtonText("Close")
                    .showDialog();
        }
        else{
            popupDialog.setStyle(style)
                    .setHeading("This is heading")
                    .setLottieRepeatCount(0)
                    .setDescription("This is the description")
                    .setDismissButtonText("Close")
                    .showDialog(new OnDialogButtonClickListener() {
                        @Override
                        public void onDismissClicked(Dialog dialog) {
                            dialog.dismiss();
                        }
                    });
        }
    }

}
