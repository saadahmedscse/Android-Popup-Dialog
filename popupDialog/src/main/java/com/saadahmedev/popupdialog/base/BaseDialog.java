package com.saadahmedev.popupdialog.base;

import android.app.Dialog;
import android.content.Context;

import com.saadahmedev.popupdialog.PopupDialog;

public class BaseDialog<T> {

    private final PopupDialog popupDialog;
    private final Context context;
    private final Dialog dialog;

    public PopupDialog getPopupDialog() {
        return popupDialog;
    }

    public Context getContext() {
        return context;
    }

    public Dialog getDialog() {
        return dialog;
    }

    protected BaseDialog(PopupDialog popupDialog) {
        this.popupDialog = popupDialog;
        this.context = popupDialog.getContext();
        this.dialog = popupDialog.getDialog();
    }

    public T setCancelable(boolean isCancelable) {
        this.popupDialog.setCancelable(isCancelable);
        return castType();
    }

    public T setTimeout(long milliseconds) {
        this.popupDialog.setTimeout(milliseconds);
        return castType();
    }

    @SuppressWarnings("unchecked")
    private T castType() {
        return (T) this;
    }
}
