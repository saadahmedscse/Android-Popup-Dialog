package com.saadahmedsoft.popupdialog.listener;

import android.app.Dialog;

public abstract class OnDialogButtonClickListener {
    public void onPositiveClicked(Dialog dialog) {}
    public void onNegativeClicked(Dialog dialog) {}
    public void onDismissClicked(Dialog dialog) {}
}
