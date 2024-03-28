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

package com.saadahmedev.popupdialog.dialog.progress;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.R;
import com.saadahmedev.popupdialog.base.BaseDialogBinder;
import com.saadahmedev.popupdialog.databinding.DialogProgressBinding;
import com.saadahmedev.popupdialog.dialogType.ProgressTypeDialog;

public class ProgressDialog extends BaseDialogBinder<ProgressDialog, DialogProgressBinding> {

    private final ProgressTypeDialog progressTypeDialog;

    private Integer tint;

    private ProgressDialog(ProgressTypeDialog progressTypeDialog) {
        super(progressTypeDialog.getPopupDialog(), R.layout.dialog_progress);
        this.progressTypeDialog = progressTypeDialog;
    }

    public static ProgressDialog getInstance(ProgressTypeDialog progressTypeDialog) {
        return new ProgressDialog(progressTypeDialog);
    }

    public ProgressDialog setTint(@NonNull @ColorRes Integer tint) {
        this.tint = tint;
        return this;
    }

    public PopupDialog build() {
        if (tint != null) binding.progressBar.setIndeterminateTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), this.tint)));

        return progressTypeDialog.getPopupDialog();
    }
}
