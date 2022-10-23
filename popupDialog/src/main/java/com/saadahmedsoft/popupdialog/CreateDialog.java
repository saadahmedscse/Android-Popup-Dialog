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

    /**
     * Create Dialog class.
     * Created by Saad Ahmed on 17-May-2022.
     * A class which creates many kind of dialogs which you can modify easily.
     */

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

    /**
     * Private constructor of create dialog class
     * @param context is required for some use cases
     * @param style is required to create the dialog
     * @param dialog is required to modify it
     */

    private CreateDialog(Context context, Styles style, Dialog dialog) {
        this.context = context;
        this.style = style;
        this.dialog = dialog;
    }

    /**
     * Static function to get instance of create dialog class
     * @param context is required to create instance of create dialog class
     * @param style is required to create the dialog
     * @param dialog is required to modify it later
     * @return instance of create dialog class
     */

    public static CreateDialog getInstance(Context context, Styles style, Dialog dialog) {
        if (instance == null) {
            instance = new CreateDialog(context, style, dialog);
        }
        return instance;
    }

    /**
     * Heading will be shown as dialog heading
     * @param heading is not required. The dialog heading will be blank if the heading become null
     * @return instance of create dialog class
     */

    public CreateDialog setHeading(String heading) {
        this.heading = heading;
        return instance;
    }

    /**
     * Description will be shown as dialog description
     * @param description is not required. The dialog description will be blank if the description become null
     * @return instance of create dialog class
     */

    public CreateDialog setDescription(String description) {
        this.description = description;
        return instance;
    }

    /**
     * This String will be shown as positive button text
     * @param positiveButtonText is not required. If it become null then the default value "Submit" will be shown as positive button text
     * @return instance of create dialog class
     */

    public CreateDialog setPositiveButtonText(String positiveButtonText) {
        this.positiveButtonText = positiveButtonText;
        return instance;
    }

    /**
     * This String will be shown as negative button text
     * @param negativeButtonText is not required. If it become null then the default value "Cancel" will be shown as negative button text
     * @return instance of create dialog class
     */

    public CreateDialog setNegativeButtonText(String negativeButtonText) {
        this.negativeButtonText = negativeButtonText;
        return instance;
    }

    /**
     * This String will be shown as dismiss button text
     * @param dismissButtonText is not required. If it become null then the default value "Dismiss" will be shown as dismiss button text
     * @return instance of create dialog class
     */

    public CreateDialog setDismissButtonText(String dismissButtonText) {
        this.dismissButtonText = dismissButtonText;
        return instance;
    }

    /**
     * This color will be shown as positive button text color
     * @param color is not required. If it become null then the default color "#FFFFFF" will be shown as positive button text color
     * @return instance of create dialog class
     */

    public CreateDialog setPositiveButtonTextColor(@ColorRes int color) {
        this.positiveButtonTextColor = color;
        return instance;
    }

    /**
     * This color will be shown as negative button text color
     * @param color is not required. If it become null then the default color "#FFFFFF" will be shown as negative button text color
     * @return instance of create dialog class
     */

    public CreateDialog setNegativeButtonTextColor(@ColorRes int color) {
        this.negativeButtonTextColor = color;
        return instance;
    }

    /**
     * This color will be shown as dismiss button text color
     * @param color is not required. If it become null then the default color "#202020" will be shown as dismiss button text color
     * @return instance of create dialog class
     */

    public CreateDialog setDismissButtonTextColor(@ColorRes int color) {
        this.dismissButtonTextColor = color;
        return instance;
    }

    /**
     * This background will be shown as positive button background
     * @param background is not required. If it become null then the default background "bg_blue_10" will be shown as positive button background
     * @return instance of create dialog class
     */

    public CreateDialog setPositiveButtonBackground(@DrawableRes int background) {
        this.positiveButtonBackground = background;
        return instance;
    }

    /**
     * This background will be shown as negative button background
     * @param background is not required. If it become null then the default background "bg_light_grey_10" will be shown as negative button background
     * @return instance of create dialog class
     */

    public CreateDialog setNegativeButtonBackground(@DrawableRes int background) {
        this.negativeButtonBackground = background;
        return instance;
    }

    /**
     * This background will be shown as dismiss button background
     * @param background is not required. If it become null then the default background "bg_dark_grey_10" will be shown as dismiss button background
     * @return instance of create dialog class
     */

    public CreateDialog setDismissButtonBackground(@DrawableRes int background) {
        this.dismissButtonBackground = background;
        return instance;
    }

    /**
     * This icon will be shown as standard dialog icon
     * @param icon is required. If it become null then the default icon "ic_home" will be shown as standard dialog icon
     * @return instance of create dialog class
     */

    public CreateDialog setPopupDialogIcon(@DrawableRes int icon) {
        this.icon = icon;
        return instance;
    }

    /**
     * This icon tint will be shown as standard dialog icon color
     * @param iconTint is required. If it become null then the default color "#000000" will be shown as standard dialog icon color
     * @return instance of create dialog class
     */

    public CreateDialog setPopupDialogIconTint(@ColorRes int iconTint) {
        this.iconTint = iconTint;
        return instance;
    }

    /**
     * This cancelable is a boolean defines the is is cancelable or not while touching outside
     * @param cancelable is not required. If it become null then the default value "true" will be defined as cancelable
     * @return instance of create dialog class
     */

    public CreateDialog setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        this.dialog.setCancelable(cancelable);
        return instance;
    }

    /**
     * This color will be shown as heading text color
     * @param color is not required. If it become null then the default color "#202020" will be shown as heading text color
     * @return instance of create dialog class
     */

    public CreateDialog setHeadingTextColor(@ColorRes int color) {
        this.headingTextColor = color;
        return instance;
    }

    /**
     * This color will be shown as description text color
     * @param color is not required. If it become null then the default color "#202020" will be shown as description text color
     * @return instance of create dialog class
     */

    public CreateDialog setDescriptionTextColor(@ColorRes int color) {
        this.descriptionTextColor = color;
        return instance;
    }

    /**
     * This background will be shown as the dialog parent layout background
     * @param background is not required. If it become null then the default background "bg_white_10" will be shown as dialog parent layout background
     * @return instance of create dialog class
     */

    public CreateDialog setDialogBackground(@DrawableRes int background) {
        this.dialogBackground = background;
        return instance;
    }

    /**
     * This color will be shown as the progress dialog tint
     * @param tint is not required. If it become null then the default color "#215C5C" will be shown as progress dialog tint
     * @return instance of create dialog class
     */

    public CreateDialog setProgressDialogTint(@ColorInt int tint) {
        this.tint = tint;
        return instance;
    }

    /**
     * Dialog will be closed after the timeout
     * @param seconds is not required. If it become null then the dialog will not close automatically
     * @return instance of create dialog class
     */

    public CreateDialog setTimeout(long seconds) {
        new Handler().postDelayed(dialog::dismiss, seconds * 1000);
        return instance;
    }

    /**
     * This asset name will be the lottie animation name in asset folder
     * @param assetName or rawRes is required. If it become null then the lottie animation progress bar will not show
     * @return instance of create dialog class
     */

    public CreateDialog setLottieAssetName(String assetName) {
        this.lottieFile = assetName;
        return instance;
    }

    /**
     * This rawRes will be the lottie animation resource in raw folder
     * @param rawRes or assetName is required. If it become null then the lottie animation progress bar will not show
     * @return instance of create dialog class
     */

    public CreateDialog setLottieRawRes(@RawRes int rawRes) {
        this.lottieRaw = rawRes;
        return instance;
    }

    /**
     * This repeatCount will define how many times will the animation become repeated
     * @param repeatCount is not required. If it become null then the lottie animation will be played only once
     * @return instance of create dialog class
     */

    public CreateDialog setLottieRepeatCount(int repeatCount) {
        this.lottieRepeatCount = repeatCount;
        return instance;
    }

    /**
     * This speed will define how much speed of the animation animate will be
     * @param speed is not required. If it become null then the lottie animation will animate with it's default speed
     * @return instance of create dialog class
     */

    public CreateDialog setLottieAnimationSpeed(float speed) {
        this.lottieAnimationSpeed = speed;
        return instance;
    }

    /**
     * This timeout defines how much time will the dialog be visible
     * @param seconds is not required. If it become null then the progress of lottie progress dialog will not close by itself
     * @return instance of create dialog class
     */

    public CreateDialog setLottieDialogTimeout(long seconds) {
        this.progressDialogTimeout = seconds;
        return instance;
    }

    /**
     * This function will show the progress dialogs [Styles.PROGRESS or Styles.LOTTIE_ANIMATION]
     */

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

    /**
     * This function will show the popup dialogs [Styles.SUCCESS or Styles.IOS or Styles.STANDARD etc.]
     * @param listener is required to get the callback on positive or negative or dismiss button clicked
     */

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

    /**
     * This is a private function will show the dialog it it's not showing
     */

    private void show() {
        if (!dialog.isShowing()) {
            instance = null;
            dialog.show();
        }
    }

    /**
     * This is a type function of progress dialogs only. e.g: Default of Lottie
     * @param layout is required for the dialog content view
     */

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
            new Handler().postDelayed(dialog::dismiss, progressDialogTimeout);
        }
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        show();
    }

    /**
     * This function will show the android default alert dialog
     * @param listener is required to get the callback on positive or negative button clicked
     */

    private void showAlertDialog(OnDialogButtonClickListener listener) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setTitle(heading)
                .setMessage(description)
                .setPositiveButton(positiveButtonText == null ? "Submit" : positiveButtonText, (dialogInterface, i) -> listener.onPositiveClicked(dialog))
                .setNegativeButton(negativeButtonText == null ? "Cancel" : negativeButtonText, ((dialogInterface, i) -> listener.onNegativeClicked(dialog)));
        alertDialog.setCancelable(cancelable);
        alertDialog.show();
    }

    /**
     * This a type function of popup dialogs without any kind of icon
     * @param layout is required for the dialog content view
     * @param listener is required to get the callback on positive or negative or dismiss button clicked
     */

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
        if (positiveButtonText != null) {
            btnPositive.setText(positiveButtonText);
        }
        if (negativeButtonText != null) {
            btnNegative.setText(negativeButtonText);
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

    /**
     * This a type function of popup dialogs with any kind of icon
     * @param layout is required for the dialog content view
     * @param listener is required to get the callback on positive or negative or dismiss button clicked
     */

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

    /**
     * This a type function of popup dialogs with lottie animation icon
     * @param style is to create the dialog
     * @param listener is required to get the callback on positive or negative or dismiss button clicked
     */

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

    /**
     * This function will set the layout content to the dialog
     * @param layout is required to set the content view in dialog
     */

    private void setContentView(@LayoutRes int layout) {
        dialog.setContentView(layout);
    }
}
