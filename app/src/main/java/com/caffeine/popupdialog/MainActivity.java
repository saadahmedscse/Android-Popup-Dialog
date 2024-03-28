package com.caffeine.popupdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;

import com.caffeine.popupdialog.databinding.ActivityMainBinding;
import com.caffeine.popupdialog.util.DialogUtil;
import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.listener.StandardDialogActionListener;
import com.saadahmedev.popupdialog.listener.StatusDialogActionListener;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DialogUtil.showSuccessDialog(this);
    }
}
