package com.saadahmedev.popupdialog.dialog.status;

import androidx.annotation.NonNull;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.R;
import com.saadahmedev.popupdialog.base.BaseStatusDialog;
import com.saadahmedev.popupdialog.databinding.DialogStandardBinding;

public class StatusDialog extends BaseStatusDialog<StatusDialog, DialogStandardBinding> {

    private StatusDialog(PopupDialog popupDialog) {
        super(popupDialog, R.layout.dialog_status);
    }

    public static StatusDialog getInstance(PopupDialog popupDialog) {
        return new StatusDialog(popupDialog);
    }

    @Override
    public StatusDialog setLottieIcon(@NonNull Integer lottieRaw) {
        return super.setLottieIcon(lottieRaw);
    }

    @Override
    public StatusDialog setLottieIcon(@NonNull String lottieAsset) {
        return super.setLottieIcon(lottieAsset);
    }
}
