package com.saadahmedsoft.popupdialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;

public class CreateDialog {

    @SuppressLint("StaticFieldLeak")
    private static CreateDialog instance = null;
    private final Context context;
    private Styles style;
    private final Dialog dialog;

    private String heading, description, actionButtonText = "Submit", closeButtonText = "Cancel";
    private ImageView icon;

    private CreateDialog(Context context, Styles style, Dialog dialog) {
        this.context = context;
        this.style = style;
        this.dialog = dialog;

    }

    public static CreateDialog getInstance(Context context, Styles style, Dialog dialog) {
        if (instance == null) {
            instance = new CreateDialog(context, style, dialog);
        }
        return instance;
    }

    public CreateDialog setHeading(String heading) {
        this.heading = heading;
        return instance;
    }

    public CreateDialog setDescription(String description) {
        this.description = description;
        return instance;
    }

    public CreateDialog setActionButtonText(String actionButtonText) {
        this.actionButtonText = actionButtonText;
        return instance;
    }

    public CreateDialog setCloseButtonText(String closeButtonText) {
        this.closeButtonText = closeButtonText;
        return instance;
    }

    public CreateDialog setDialogIcon(@DrawableRes int icon) {
        this.icon.setImageResource(icon);
        return instance;
    }

    public CreateDialog setDialogIconTint(@ColorRes int iconTint) {
        if (this.icon != null) {
            this.icon.setColorFilter(ContextCompat.getColor(context, iconTint), android.graphics.PorterDuff.Mode.SRC_IN);
        }
        return instance;
    }

    public CreateDialog setCancelable(boolean cancelable) {
        this.dialog.setCancelable(cancelable);
        return instance;
    }

    public void showDialog() {
        switch (style) {
            case PROGRESS: {
                //dialog.setContentView(156);
                break;
            }
            case DEFAULT: {
                //dialog.setContentView(15);
                break;
            }
        }
    }
}
