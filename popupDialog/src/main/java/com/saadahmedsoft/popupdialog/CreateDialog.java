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
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener;

public class CreateDialog {

    @SuppressLint("StaticFieldLeak")
    private static CreateDialog instance = null;
    private final Context context;
    private final Styles style;
    private final Dialog dialog;
    private String heading, description, positiveButtonText, negativeButtonText, dismissButtonText, lottieFile;
    private boolean cancelable = true;
    @ColorInt
    @Nullable
    private Integer tint;
    @Nullable
    private Integer lottieRepeatCount;
    @Nullable
    private Float lottieAnimationSpeed;
    @Nullable
    private Long progressDialogTimeout;
    @RawRes
    @Nullable
    private Integer lottieRaw;
    @ColorRes
    @Nullable
    private Integer positiveButtonTextColor, negativeButtonTextColor, dismissButtonTextColor, headingTextColor, descriptionTextColor, iconTint;
    @DrawableRes
    @Nullable
    private Integer icon, dialogBackground, positiveButtonBackground, negativeButtonBackground, dismissButtonBackground;

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

    public CreateDialog setPositiveButtonText(String positiveButtonText) {
        this.positiveButtonText = positiveButtonText;
        return instance;
    }

    public CreateDialog setNegativeButtonText(String negativeButtonText) {
        this.negativeButtonText = negativeButtonText;
        return instance;
    }

    public CreateDialog setDismissButtonText(String dismissButtonText) {
        this.dismissButtonText = dismissButtonText;
        return instance;
    }

    public CreateDialog setPositiveButtonTextColor(@ColorRes int color) {
        this.positiveButtonTextColor = color;
        return instance;
    }

    public CreateDialog setNegativeButtonTextColor(@ColorRes int color) {
        this.negativeButtonTextColor = color;
        return instance;
    }

    public CreateDialog setDismissButtonTextColor(@ColorRes int color) {
        this.dismissButtonTextColor = color;
        return instance;
    }

    public CreateDialog setPositiveButtonBackground(@DrawableRes int background) {
        this.positiveButtonBackground = background;
        return instance;
    }

    public CreateDialog setNegativeButtonBackground(@DrawableRes int background) {
        this.negativeButtonBackground = background;
        return instance;
    }

    public CreateDialog setDismissButtonBackground(@DrawableRes int background) {
        this.dismissButtonBackground = background;
        return instance;
    }

    public CreateDialog setDialogIcon(@DrawableRes int icon) {
        this.icon = icon;
        return instance;
    }

    public CreateDialog setDialogIconTint(@ColorRes int iconTint) {
        this.iconTint = iconTint;
        return instance;
    }

    public CreateDialog setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        this.dialog.setCancelable(cancelable);
        return instance;
    }

    public CreateDialog setHeadingTextColor(@ColorRes int color) {
        this.headingTextColor = color;
        return instance;
    }

    public CreateDialog setDescriptionTextColor(@ColorRes int color) {
        this.descriptionTextColor = color;
        return instance;
    }

    public CreateDialog setDialogBackground(@DrawableRes int background) {
        this.dialogBackground = background;
        return instance;
    }

    public CreateDialog setTint(@ColorInt int tint) {
        this.tint = tint;
        return instance;
    }

    public CreateDialog setTimeout(long seconds) {
        new Handler().postDelayed(dialog::dismiss, seconds * 1000);
        return instance;
    }

    public CreateDialog setLottieAssetName(String assetName) {
        this.lottieFile = assetName;
        return instance;
    }

    public CreateDialog setLottieRawRes(@RawRes int rawRes) {
        this.lottieRaw = rawRes;
        return instance;
    }

    public CreateDialog setLottieRepeatCount(int repeatCount) {
        this.lottieRepeatCount = repeatCount;
        return instance;
    }

    public CreateDialog setLottieAnimationSpeed(float speed) {
        this.lottieAnimationSpeed = speed;
        return instance;
    }

    public CreateDialog setDialogTimeout(long seconds) {
        this.progressDialogTimeout = seconds;
        return instance;
    }

    public void showDialog() {
        switch (style) {
            case PROGRESS: {
                showProgressDialog(R.layout.dialog_progress);
                break;
            }
            case LOTTIE_ANIMATION: {
                showProgressDialog(R.layout.dialog_lottie);
                break;
            }
        }
    }

    public void showDialog(OnDialogButtonClickListener listener) {
        switch (style) {
            case ANDROID_DEFAULT: {
                showAlertDialog(listener);
                break;
            }
            case IOS: {
                dialogStyleOne(R.layout.dialog_ios, listener);
                show();
                break;
            }
            case STANDARD: {
                dialogStyleTwo(R.layout.dialog_standard, listener);
                show();
                break;
            }
            case SUCCESS: {
                dialogStyleThree(Styles.SUCCESS, listener);
                show();
                break;
            }
            case FAILED: {
                dialogStyleThree(Styles.FAILED, listener);
                show();
                break;
            }
            case ALERT: {
                dialogStyleThree(Styles.ALERT, listener);
                show();
                break;
            }
        }
    }
    
    private void show() {
        if (!dialog.isShowing()) {
            instance = null;
            dialog.show();
        }
    }

    private void showProgressDialog(@LayoutRes int layout) {
        setContentView(layout);
        if (tint != null && style == Styles.PROGRESS) {
            ProgressBar progressBar = dialog.findViewById(R.id.progress_bar);
            progressBar.getIndeterminateDrawable().setColorFilter(tint, PorterDuff.Mode.SRC_IN);
        }
        if (style == Styles.LOTTIE_ANIMATION) {
            LottieAnimationView lottieAnimation = dialog.findViewById(R.id.lottie_animation_view);
            if (lottieFile != null) {
                lottieAnimation.setAnimation(lottieFile);
            }
            if (lottieRaw != null) {
                lottieAnimation.setAnimation(lottieRaw);
            }
            if (lottieRepeatCount != null) {
                lottieAnimation.setRepeatMode(lottieRepeatCount);
            }
            if (lottieAnimationSpeed != null) {
                lottieAnimation.setSpeed(lottieAnimationSpeed);
            }
        }
        if (progressDialogTimeout != null) {
            new Handler().postDelayed((Runnable) dialog::dismiss, progressDialogTimeout);
        }
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        show();
    }

    private void showAlertDialog(OnDialogButtonClickListener listener) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setTitle(heading)
                .setMessage(description)
                .setPositiveButton(positiveButtonText == null ? "Submit" : positiveButtonText, (dialogInterface, i) -> listener.onPositiveClicked(dialog))
                .setNegativeButton(negativeButtonText == null ? "Cancel" : negativeButtonText, ((dialogInterface, i) -> listener.onNegativeClicked(dialog)));
        alertDialog.setCancelable(cancelable);
        alertDialog.show();
    }

    private void dialogStyleOne(@LayoutRes int layout, OnDialogButtonClickListener listener) {
        setContentView(layout);
        TextView heading, description, btnNegative, btnPositive;
        ConstraintLayout root;

        root = dialog.findViewById(R.id.root_layout);
        heading = dialog.findViewById(R.id.tv_heading);
        description = dialog.findViewById(R.id.tv_description);
        btnNegative = dialog.findViewById(R.id.btn_negative);
        btnPositive = dialog.findViewById(R.id.btn_positive);

        if (this.heading != null) {
            heading.setText(this.heading);
        }
        if (this.description != null) {
            description.setText(this.description);
        }
        if (dialogBackground != null) {
            root.setBackgroundResource(dialogBackground);
        }
        if (positiveButtonTextColor != null) {
            btnPositive.setTextColor(ContextCompat.getColor(context, positiveButtonTextColor));
        }
        if (negativeButtonTextColor != null) {
            btnNegative.setTextColor(ContextCompat.getColor(context, negativeButtonTextColor));
        }
        if (positiveButtonBackground != null) {
            btnPositive.setBackgroundResource(positiveButtonBackground);
        }
        if (negativeButtonBackground != null) {
            btnNegative.setBackgroundResource(negativeButtonBackground);
        }
        if (headingTextColor != null) {
            heading.setTextColor(ContextCompat.getColor(context, headingTextColor));
        }
        if (descriptionTextColor != null) {
            description.setTextColor(ContextCompat.getColor(context, descriptionTextColor));
        }

        btnPositive.setOnClickListener(view -> listener.onPositiveClicked(dialog));
        btnNegative.setOnClickListener(view -> listener.onNegativeClicked(dialog));

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    private void dialogStyleTwo(@LayoutRes int layout, OnDialogButtonClickListener listener) {
        dialogStyleOne(layout, listener);
        ImageView icon = dialog.findViewById(R.id.iv_icon);

        if (this.icon != null) {
            icon.setImageResource(this.icon);
        }
        if (this.iconTint != null) {
            icon.setColorFilter(ContextCompat.getColor(context, iconTint), android.graphics.PorterDuff.Mode.SRC_IN);
        }
    }

    private void dialogStyleThree(Styles style, OnDialogButtonClickListener listener) {
        setContentView(R.layout.dialog_success_failed_alert);

        LottieAnimationView icon = dialog.findViewById(R.id.lottie_icon);
        ConstraintLayout root = dialog.findViewById(R.id.root_layout);
        TextView heading, description, btnDismiss;
        heading = dialog.findViewById(R.id.tv_heading);
        description = dialog.findViewById(R.id.tv_description);
        btnDismiss = dialog.findViewById(R.id.btn_dismiss);

        btnDismiss.setOnClickListener(view -> listener.onDismissClicked(dialog));

        if (this.heading != null) {
            heading.setText(this.heading);
        }
        if (this.description != null) {
            description.setText(this.description);
        }
        if (dialogBackground != null) {
            root.setBackgroundResource(dialogBackground);
        }
        if (dismissButtonBackground != null) {
            btnDismiss.setBackgroundResource(dismissButtonBackground);
        }
        if (dismissButtonText != null) {
            btnDismiss.setText(dismissButtonText);
        }
        if (dismissButtonTextColor != null) {
            btnDismiss.setTextColor(ContextCompat.getColor(context, dismissButtonTextColor));
        }
        if (headingTextColor != null) {
            heading.setTextColor(ContextCompat.getColor(context, headingTextColor));
        }
        if (descriptionTextColor != null) {
            description.setTextColor(ContextCompat.getColor(context, descriptionTextColor));
        }

        switch (style) {
            case SUCCESS: {
                icon.setAnimation(R.raw.success);
                btnDismiss.setBackgroundResource(R.drawable.ripple_bg_dark_grey_10);
                break;
            }
            case FAILED: {
                icon.setAnimation(R.raw.failed);
                btnDismiss.setBackgroundResource(R.drawable.ripple_bg_red_10);
                break;
            }
            case ALERT: {
                icon.setAnimation(R.raw.warning);
                if (dismissButtonTextColor == null) btnDismiss.setTextColor(ContextCompat.getColor(context, R.color.colorDarkGrey));
                btnDismiss.setBackgroundResource(R.drawable.ripple_bg_yellow_10);
                break;
            }
        }

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    private void setContentView(@LayoutRes int layout) {
        dialog.setContentView(layout);
    }
}
