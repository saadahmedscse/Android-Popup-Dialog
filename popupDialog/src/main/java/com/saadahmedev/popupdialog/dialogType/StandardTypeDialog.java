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
import com.saadahmedev.popupdialog.dialog.standard.AlertDialog;
import com.saadahmedev.popupdialog.dialog.standard.IOSDialog;
import com.saadahmedev.popupdialog.dialog.standard.StandardDialog;

public class StandardTypeDialog extends BaseDialog<StandardTypeDialog> {

    private StandardTypeDialog(PopupDialog popupDialog) {
        super(popupDialog);
    }

    public static StandardTypeDialog getInstance(PopupDialog popupDialog) {
        return new StandardTypeDialog(popupDialog);
    }

    public StandardDialog createStandardDialog() {
        return StandardDialog.getInstance(super.getPopupDialog());
    }

    public IOSDialog createIOSDialog() {
        return IOSDialog.getInstance(super.getPopupDialog());
    }

    public AlertDialog createAlertDialog() {
        return AlertDialog.getInstance(super.getPopupDialog());
    }
}
