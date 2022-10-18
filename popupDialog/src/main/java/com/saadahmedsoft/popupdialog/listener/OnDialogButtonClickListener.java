package com.saadahmedsoft.popupdialog.listener;

import android.app.Dialog;

public interface OnDialogButtonClickListener {
    void onPositiveClicked(Dialog dialog);
    void onNegativeClicked(Dialog dialog);
}
