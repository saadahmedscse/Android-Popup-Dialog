package com.saadahmedev.popupdialog.dialog.status;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.R;
import com.saadahmedev.popupdialog.base.BaseStatusDialog;
import com.saadahmedev.popupdialog.databinding.DialogStatusBinding;

public class SuccessDialog extends BaseStatusDialog<SuccessDialog, DialogStatusBinding> {

    private SuccessDialog(PopupDialog popupDialog) {
        super(popupDialog, R.layout.dialog_status);
        super.setLottieIcon(R.raw.success);
    }

    public static SuccessDialog getInstance(PopupDialog popupDialog) {
        return new SuccessDialog(popupDialog);
    }
}
