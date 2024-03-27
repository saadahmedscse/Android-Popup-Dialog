package com.saadahmedev.popupdialog.dialog.standard;

import androidx.core.content.ContextCompat;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.R;
import com.saadahmedev.popupdialog.base.BaseStandardDialog;
import com.saadahmedev.popupdialog.databinding.DialogAlertBinding;
import com.saadahmedev.popupdialog.dto.AlertDialogData;
import com.saadahmedev.popupdialog.listener.StandardDialogActionListener;

public class AlertDialog extends BaseStandardDialog<AlertDialog, DialogAlertBinding> {

    private AlertDialog(PopupDialog popupDialog) {
        super(popupDialog, R.layout.dialog_alert);
    }

    public static AlertDialog getInstance(PopupDialog popupDialog) {
        return new AlertDialog(popupDialog);
    }

    @Override
    public PopupDialog build(StandardDialogActionListener listener) {
        super.build(listener);

        binding.btnPositive.setTypeface(super.buttonFont);
        binding.btnNegative.setTypeface(super.buttonFont);
        binding.tvHeading.setTypeface(super.headingFont);
        binding.tvDescription.setTypeface(super.descriptionFont);
        binding.btnPositive.setTextSize(super.buttonFontSize);
        binding.btnNegative.setTextSize(super.buttonFontSize);
        binding.tvHeading.setTextSize(super.headingFontSize);
        binding.tvDescription.setTextSize(super.descriptionFontSize);

        if (super.background != null) {
            binding.layoutRoot.setBackgroundResource(super.background);
        }
        else if (super.backgroundColor != null) {
            binding.layoutRoot.setBackground(
                    getBackground(
                            ContextCompat.getColor(binding.layoutRoot.getContext(), backgroundColor),
                            super.backgroundTopLeftCornerRadius,
                            super.backgroundTopRightCornerRadius,
                            super.backgroundBottomLeftCornerRadius,
                            super.backgroundBottomRightCornerRadius
                    )
            );
        }

        binding.setDialog(super.getDialog());
        binding.setListener(listener);
        binding.setItem(
                new AlertDialogData(
                        super.heading,
                        super.description,
                        super.headingTextColor,
                        super.descriptionTextColor,
                        super.positiveButtonTextColor,
                        super.negativeButtonTextColor,
                        super.positiveButtonText,
                        super.negativeButtonText
                )
        );

        return super.getPopupDialog();
    }
}
