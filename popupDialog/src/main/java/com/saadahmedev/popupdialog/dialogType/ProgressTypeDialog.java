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

package com.saadahmedev.popupdialog.dialogType;

import com.saadahmedev.popupdialog.dialog.progress.LottieDialog;
import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.dialog.progress.ProgressDialog;
import com.saadahmedev.popupdialog.base.BaseDialog;

public class ProgressTypeDialog extends BaseDialog<ProgressTypeDialog> {

    private ProgressTypeDialog(PopupDialog popupDialog) {
        super(popupDialog);
    }

    public static ProgressTypeDialog getInstance(PopupDialog popupDialog) {
        return new ProgressTypeDialog(popupDialog);
    }

    public ProgressDialog createProgressDialog() {
        return ProgressDialog.getInstance(this);
    }

    public LottieDialog createLottieDialog() {
        return LottieDialog.getInstance(this);
    }
}
