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
