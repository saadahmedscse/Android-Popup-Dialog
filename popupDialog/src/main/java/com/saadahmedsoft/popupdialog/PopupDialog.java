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

package com.saadahmedsoft.popupdialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;

public class PopupDialog {

    /**
     * Popup Dialog class.
     * Created by Saad Ahmed on 17-May-2022.
     * Github: https://github.com/saadahmedscse/Android-Popup-Dialog
     * A custom android popup dialog library which provides you a lot of popup dialog and progress dialog with and without animation
     */

    private final Dialog dialog;
    private final Context context;
    @SuppressLint("StaticFieldLeak")
    private static PopupDialog instance = null;

    /**
     * Private constructor of popup dialog
     * @param context is required to create instance of dialog
     */

    private PopupDialog(Context context) {
        this.context = context;
        dialog = new Dialog(context);
    }

    /**
     * Static function to get instance of popup dialog class
     * @param context is required to create instance of popup dialog class
     * @return instance of popup dialog class
     */

    public static PopupDialog getInstance(Context context) {
        if (instance == null) {
            instance = new PopupDialog(context);
        }
        return instance;
    }

    /**
     * setStyle function will set the style which you want
     * @param style is required to create instance of create dialog class
     * @return instance of create dialog class
     */

    public CreateDialog setStyle(Styles style) {
        instance = null;
        return CreateDialog.getInstance(context, style, dialog);
    }

    /**
     * Dismiss the dialog if it is showing
     */

    public void dismissDialog() {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
