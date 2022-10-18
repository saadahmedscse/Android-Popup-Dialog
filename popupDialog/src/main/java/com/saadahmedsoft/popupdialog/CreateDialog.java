package com.saadahmedsoft.popupdialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;

import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener;

public class CreateDialog {

    @SuppressLint("StaticFieldLeak")
    private static CreateDialog instance = null;
    private final Context context;
    private final Styles style;
    private final Dialog dialog;

    private String heading, description, actionButtonText = "Submit", closeButtonText = "Cancel";
    private ImageView icon;
    private boolean cancelable = true;

    @ColorInt
    @Nullable
    private Integer tint, actionButtonTextColor, closeButtonTextColor, headingTextColor, descriptionTextColor;

    @DrawableRes
    @Nullable
    private Integer dialogBackground, actionButtonBackground, closeButtonBackground;

    private OnDialogButtonClickListener listener;

    private CreateDialog(Context context, Styles style, Dialog dialog) {
        this.context = context;
        this.style = style;
        this.dialog = dialog;
    }

    private CreateDialog(Context context, Styles style, Dialog dialog, OnDialogButtonClickListener listener) {
        this.context = context;
        this.style = style;
        this.dialog = dialog;
        this.listener = listener;
    }

    public static CreateDialog getInstance(Context context, Styles style, Dialog dialog) {
        if (instance == null) {
            instance = new CreateDialog(context, style, dialog);
        }
        return instance;
    }

    public static CreateDialog getInstance(Context context, Styles style, Dialog dialog, OnDialogButtonClickListener listener) {
        if (instance == null) {
            instance = new CreateDialog(context, style, dialog, listener);
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
        this.cancelable = cancelable;
        this.dialog.setCancelable(cancelable);
        return instance;
    }

    public CreateDialog setActionButtonTextColor(@ColorInt int color) {
        this.actionButtonTextColor = color;
        return instance;
    }

    public CreateDialog setCloseButtonTextColor(@ColorInt int color) {
        this.closeButtonTextColor = color;
        return instance;
    }

    public CreateDialog setHeadingButtonTextColor(@ColorInt int color) {
        this.headingTextColor = color;
        return instance;
    }

    public CreateDialog setDescriptionButtonTextColor(@ColorInt int color) {
        this.descriptionTextColor = color;
        return instance;
    }

    public CreateDialog setDialogBackground(@DrawableRes int background) {
        this.dialogBackground = background;
        return instance;
    }

    public CreateDialog setActionButtonBackground(@DrawableRes int background) {
        this.actionButtonBackground = background;
        return instance;
    }

    public CreateDialog setCloseButtonBackground(@DrawableRes int background) {
        this.closeButtonBackground = background;
        return instance;
    }

    public CreateDialog setTint(@ColorInt int tint) {
//        if (style == Styles.PROGRESS) {
//            ProgressBar progressBar = dialog.findViewById(R.id.progress_bar);
//            progressBar.getIndeterminateDrawable().setColorFilter(tint, PorterDuff.Mode.SRC_IN);
//        }
        this.tint = tint;
        return instance;
    }

    public CreateDialog setTimeout(long seconds) {
        new Handler().postDelayed(dialog::dismiss, seconds * 1000);
        return instance;
    }

    public void showDialog() {
        switch (style) {
            case PROGRESS: {
                dialog.setContentView(R.layout.dialog_progress);
                ProgressBar progressBar = dialog.findViewById(R.id.progress_bar);
                if (tint != null) {
                    progressBar.getIndeterminateDrawable().setColorFilter(tint, PorterDuff.Mode.SRC_IN);
                }
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                show();
                break;
            }
            case ALERT_DIALOG: {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                        .setTitle(heading)
                        .setMessage(description)
                        .setPositiveButton(actionButtonText, (dialogInterface, i) -> listener.onAction())
                        .setNegativeButton(closeButtonText, ((dialogInterface, i) -> listener.onClose()));
                alertDialog.setCancelable(cancelable);
                alertDialog.show();
                break;
            }
        }
    }
    
    public void dismissDialog() {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
    
    private void show() {
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }
}
