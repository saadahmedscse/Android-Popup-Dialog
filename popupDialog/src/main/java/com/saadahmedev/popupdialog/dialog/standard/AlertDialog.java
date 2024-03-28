/*
 * Copyright 2018-2024 Saad Ahmed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.saadahmedev.popupdialog.dialog.standard;

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
                            backgroundColor,
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
