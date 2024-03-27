package com.saadahmedev.popupdialog.base;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.saadahmedev.popupdialog.PopupDialog;

public class BaseDialogBinder<T, VB extends ViewDataBinding> extends BaseDialog<T> {

    protected final VB binding;

    protected BaseDialogBinder(PopupDialog popupDialog, @NonNull @LayoutRes Integer layout) {
        super(popupDialog);
        binding = DataBindingUtil.inflate(
                LayoutInflater.from(super.getContext()),
                layout,
                null,
                false
        );
        super.getDialog().setContentView(binding.getRoot());
        assert super.getDialog().getWindow() != null;
        super.getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
}
