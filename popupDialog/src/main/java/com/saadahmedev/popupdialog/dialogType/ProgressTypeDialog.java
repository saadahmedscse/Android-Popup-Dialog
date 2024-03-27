package com.saadahmedev.popupdialog.dialogType;

import com.saadahmedev.popupdialog.dialog.progress.LottieDialog;
import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.dialog.progress.ProgressDialog;
import com.saadahmedev.popupdialog.base.BaseDialog;

public class ProgressTypeDialog extends BaseDialog<ProgressTypeDialog> {

    private ProgressTypeDialog(PopupDialog popupDialog) {
        super(popupDialog);
    }

    public static ProgressTypeDialog getInstance(PopupDialog popupDialog) {
        return new ProgressTypeDialog(popupDialog);
    }

    public ProgressDialog createProgressDialog() {
        return ProgressDialog.getInstance(this);
    }

    public LottieDialog createLottieDialog() {
        return LottieDialog.getInstance(this);
    }
}
