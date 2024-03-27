package com.saadahmedev.popupdialog.dialogType;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.base.BaseDialog;
import com.saadahmedev.popupdialog.dialog.status.ErrorDialog;
import com.saadahmedev.popupdialog.dialog.status.StatusDialog;
import com.saadahmedev.popupdialog.dialog.status.SuccessDialog;
import com.saadahmedev.popupdialog.dialog.status.WarningDialog;

public class StatusTypeDialog extends BaseDialog<StandardTypeDialog> {

    private StatusTypeDialog(PopupDialog popupDialog) {
        super(popupDialog);
    }

    public static StatusTypeDialog getInstance(PopupDialog popupDialog) {
        return new StatusTypeDialog(popupDialog);
    }

    public StatusDialog createStatusDialog() {
        return StatusDialog.getInstance(super.getPopupDialog());
    }

    public SuccessDialog createSuccessDialog() {
        return SuccessDialog.getInstance(super.getPopupDialog());
    }

    public WarningDialog createWarningDialog() {
        return WarningDialog.getInstance(super.getPopupDialog());
    }

    public ErrorDialog createErrorDialog() {
        return ErrorDialog.getInstance(super.getPopupDialog());
    }
}
