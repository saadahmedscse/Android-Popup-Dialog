package com.saadahmedev.popupdialog.dialog.status;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.R;
import com.saadahmedev.popupdialog.base.BaseStatusDialog;
import com.saadahmedev.popupdialog.databinding.DialogStatusBinding;

public class WarningDialog extends BaseStatusDialog<WarningDialog, DialogStatusBinding> {

    private WarningDialog(PopupDialog popupDialog) {
        super(popupDialog, R.layout.dialog_status);
        super.setLottieIcon(R.raw.warning);
    }

    public static WarningDialog getInstance(PopupDialog popupDialog) {
        return new WarningDialog(popupDialog);
    }
}
