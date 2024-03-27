package com.saadahmedev.popupdialog.dialog.progress;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.R;
import com.saadahmedev.popupdialog.base.BaseDialogBinder;
import com.saadahmedev.popupdialog.databinding.DialogProgressBinding;
import com.saadahmedev.popupdialog.dialogType.ProgressTypeDialog;

public class ProgressDialog extends BaseDialogBinder<ProgressDialog, DialogProgressBinding> {

    private final ProgressTypeDialog progressTypeDialog;

    private Integer tint;

    private ProgressDialog(ProgressTypeDialog progressTypeDialog) {
        super(progressTypeDialog.getPopupDialog(), R.layout.dialog_progress);
        this.progressTypeDialog = progressTypeDialog;
    }

    public static ProgressDialog getInstance(ProgressTypeDialog progressTypeDialog) {
        return new ProgressDialog(progressTypeDialog);
    }

    public ProgressDialog setTint(@NonNull @ColorRes Integer tint) {
        this.tint = tint;
        return this;
    }

    public PopupDialog build() {
        if (tint != null) binding.progressBar.setIndeterminateTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), this.tint)));

        return progressTypeDialog.getPopupDialog();
    }
}
