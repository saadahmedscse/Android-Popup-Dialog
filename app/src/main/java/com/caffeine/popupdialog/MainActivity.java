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
        setClickListener();
    }

    private void setClickListener(){
        binding.buttonProgress.setOnClickListener(view ->{
            PopupDialog.getInstance(this)
                    .setStyle(Styles.PROGRESS)
                    .setProgressDialogTint(getResources().getColor(com.saadahmedsoft.popupdialog.R.color.colorRed))
                    .setCancelable(true)
                    .showDialog();
        });

        binding.buttonIos.setOnClickListener(view -> {
            PopupDialog.getInstance(this)
                    .setStyle(Styles.IOS)
                    .setHeading("Logout")
                    .setDescription("Are you sure you want to logout? This action cannot be undone")
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
        });
        binding.buttonDefault.setOnClickListener(view -> {
            PopupDialog.getInstance(this)
                    .setStyle(Styles.ANDROID_DEFAULT)
                    .setHeading("Logout")
                    .setDescription("Are you sure you want to logout? This action cannot be undone")
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
        });
        binding.buttonStandard.setOnClickListener(view -> {
            PopupDialog.getInstance(this)
                    .setStyle(Styles.STANDARD)
                    .setHeading("Logout")
                    .setDescription("Are you sure you want to logout? This action cannot be undone")
                    .setPopupDialogIcon(R.drawable.baseline_logout_24)
                    .setPopupDialogIconTint(com.saadahmedsoft.popupdialog.R.color.colorRed)
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
        });
        binding.buttonLottie.setOnClickListener(view -> {
            PopupDialog.getInstance(this)
                    .setStyle(Styles.LOTTIE_ANIMATION)
                    .setLottieRawRes(com.saadahmedsoft.popupdialog.R.raw.failed)
                    .setCancelable(true)
                    .showDialog();
        });
        binding.buttonSuccess.setOnClickListener(view -> {
            PopupDialog.getInstance(this)
                    .setStyle(Styles.SUCCESS)
                    .setHeading("Well Done")
                    .setDescription("You have successfully completed the task")
                    .setCancelable(false)
                    .showDialog(new OnDialogButtonClickListener() {
                        @Override
                        public void onDismissClicked(Dialog dialog) {
                            super.onDismissClicked(dialog);
                        }
                    });
        });
        binding.buttonFailed.setOnClickListener(view -> {
            PopupDialog.getInstance(this)
                    .setStyle(Styles.ALERT)
                    .setHeading("Pending")
                    .setDescription("You verification is under observation. Try again later.")
                    .setCancelable(false)
                    .showDialog(new OnDialogButtonClickListener() {
                        @Override
                        public void onDismissClicked(Dialog dialog) {
                            super.onDismissClicked(dialog);
                        }
                    });
        });
        binding.buttonAlert.setOnClickListener(view -> {
            PopupDialog.getInstance(this)
                    .setStyle(Styles.FAILED)
                    .setHeading("Uh-Oh")
                    .setDescription("Unexpected error occurred. Try again later.")
                    .setCancelable(false)
                    .showDialog(new OnDialogButtonClickListener() {
                        @Override
                        public void onDismissClicked(Dialog dialog) {
                            super.onDismissClicked(dialog);
                        }
                    });
        });

    }

}
