package com.saadahmedev.popupdialog.dialog.status;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.R;
import com.saadahmedev.popupdialog.base.BaseStatusDialog;
import com.saadahmedev.popupdialog.databinding.DialogStatusBinding;

public class ErrorDialog extends BaseStatusDialog<ErrorDialog, DialogStatusBinding> {

    private ErrorDialog(PopupDialog popupDialog) {
        super(popupDialog, R.layout.dialog_status);
        super.setLottieIcon(R.raw.failed);
    }

    public static ErrorDialog getInstance(PopupDialog popupDialog) {
        return new ErrorDialog(popupDialog);
    }
}
