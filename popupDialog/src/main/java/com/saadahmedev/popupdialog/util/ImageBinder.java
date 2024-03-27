package com.saadahmedev.popupdialog.util;

import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.databinding.BindingAdapter;

public class ImageBinder {

    @BindingAdapter("app:dialogIcon")
    public static void setDialogIcon(ImageView imageView, @DrawableRes Integer icon) {
        if (icon != null) {
            imageView.setImageResource(icon);
        }
    }
}
