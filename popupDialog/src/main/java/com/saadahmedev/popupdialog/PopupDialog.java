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

package com.saadahmedev.popupdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.saadahmedev.popupdialog.dialogType.ProgressTypeDialog;
import com.saadahmedev.popupdialog.dialogType.StandardTypeDialog;
import com.saadahmedev.popupdialog.dialogType.StatusTypeDialog;
import com.saadahmedev.popupdialog.exception.PopupDialogException;

public class PopupDialog {

    private final Dialog dialog;
    private final Context context;

    public Dialog getDialog() {
        return this.dialog;
    }

    public Context getContext() {
        return this.context;
    }

    private PopupDialog(Context context) {
        this.dialog = new Dialog(context);
        this.context = this.dialog.getContext();
    }

    public static PopupDialog getInstance(Context context) {
        return new PopupDialog(context);
    }

    public ProgressTypeDialog progressDialogBuilder() {
        return ProgressTypeDialog.getInstance(this);
    }

    public StandardTypeDialog standardDialogBuilder() {
        return StandardTypeDialog.getInstance(this);
    }

    public StatusTypeDialog statusDialogBuilder() {
        return StatusTypeDialog.getInstance(this);
    }

    public PopupDialog setCancelable(boolean isCancelable) {
        this.dialog.setCancelable(isCancelable);

        return this;
    }

    public PopupDialog setTimeout(long milliseconds) {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (this.dialog.isShowing()) this.dialog.dismiss();

        }, milliseconds);
        return this;
    }

    public void show() {
        if (dialog.getWindow() == null) {
            throw new PopupDialogException("Show method called before building the dialog.");
        }

        if (!this.dialog.isShowing()) this.dialog.show();
    }

    public void dismiss() {
        if (this.dialog.isShowing()) this.dialog.dismiss();
    }
}
