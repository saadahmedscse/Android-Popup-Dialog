package com.saadahmedev.popupdialog.util;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

public class TextBinder {

    @SuppressLint("ResourceAsColor")
    @BindingAdapter("app:dialogTextColor")
    public static void setDialogTextColor(TextView textView, @ColorRes Integer color) {
        if (color != null) {
            try {
                textView.setTextColor(ContextCompat.getColor(textView.getContext(), color));
            } catch (Resources.NotFoundException e) {
                textView.setTextColor(color);
            }
        }
    }
}
