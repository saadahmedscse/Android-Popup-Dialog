/*
 * Copyright 2022 Saad Ahmed
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

package com.saadahmedev.popupdialog.listener;

import android.app.Dialog;

/**
 * Dialog Button Click Callback Class.
 * Created by Saad Ahmed on 17-Oct-2022.
 * This abstract class will give user's a callback of dialog button click
 */

public abstract class OnDialogButtonClickListener {
    public void onPositiveClicked(Dialog dialog) {
        dismiss(dialog);
    }
    public void onNegativeClicked(Dialog dialog) {
        dismiss(dialog);
    }
    public void onDismissClicked(Dialog dialog) {
        dialog.dismiss();
    }

    /**
     * Dismiss the dialog by default on method call using super keyword
     * @param dialog is required to check if nonnull and isShowing
     */

    private void dismiss(Dialog dialog) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
