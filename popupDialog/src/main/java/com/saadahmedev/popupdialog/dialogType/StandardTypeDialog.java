package com.saadahmedev.popupdialog.dialogType;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.base.BaseDialog;
import com.saadahmedev.popupdialog.dialog.standard.AlertDialog;
import com.saadahmedev.popupdialog.dialog.standard.IOSDialog;
import com.saadahmedev.popupdialog.dialog.standard.StandardDialog;

public class StandardTypeDialog extends BaseDialog<StandardTypeDialog> {

    private StandardTypeDialog(PopupDialog popupDialog) {
        super(popupDialog);
    }

    public static StandardTypeDialog getInstance(PopupDialog popupDialog) {
        return new StandardTypeDialog(popupDialog);
    }

    public StandardDialog createStandardDialog() {
        return StandardDialog.getInstance(super.getPopupDialog());
    }

    public IOSDialog createIOSDialog() {
        return IOSDialog.getInstance(super.getPopupDialog());
    }

    public AlertDialog createAlertDialog() {
        return AlertDialog.getInstance(super.getPopupDialog());
    }
}
