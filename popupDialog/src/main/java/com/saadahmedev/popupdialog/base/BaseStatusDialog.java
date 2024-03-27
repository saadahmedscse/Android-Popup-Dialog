package com.saadahmedev.popupdialog.base;

import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.ViewDataBinding;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.R;
import com.saadahmedev.popupdialog.databinding.DialogStatusBinding;
import com.saadahmedev.popupdialog.dto.StatusDialogData;
import com.saadahmedev.popupdialog.exception.PopupDialogException;
import com.saadahmedev.popupdialog.listener.StatusDialogActionListener;

public class BaseStatusDialog<T, VB extends ViewDataBinding> extends BaseShapeGenerator<T, VB> {

    private static final Float DEFAULT_HEADING_FONT_SIZE = 17F;
    private static final Float DEFAULT_DESCRIPTION_FONT_SIZE = 15F;
    private static final Float DEFAULT_BUTTON_FONT_SIZE = 16F;
    private Integer lottieRaw;
    private String lottieAsset;
    private String heading;
    private String description;
    private String actionButtonText;
    private Integer headingTextColor;
    private Integer descriptionTextColor;
    private Integer actionButtonTextColor;
    private Integer background;
    private Integer backgroundColor;
    private Integer actionButtonBackground;
    private Integer actionButtonBackgroundColor;
    private Float actionButtonCornerRadius;
    private Typeface fontFamily;
    private Typeface headingFont;
    private Typeface descriptionFont;
    private Typeface buttonFont;
    private Float headingFontSize;
    private Float descriptionFontSize;
    private Float buttonFontSize;
    protected Float backgroundCornerRadius;
    protected Float backgroundTopLeftCornerRadius;
    protected Float backgroundTopRightCornerRadius;
    protected Float backgroundBottomLeftCornerRadius;
    protected Float backgroundBottomRightCornerRadius;
    private Float actionButtonTopLeftCornerRadius;
    private Float actionButtonTopRightCornerRadius;
    private Float actionButtonBottomLeftCornerRadius;
    private Float actionButtonBottomRightCornerRadius;
    private Integer actionButtonRippleColor;

    protected BaseStatusDialog(PopupDialog popupDialog, @NonNull @LayoutRes Integer layout) {
        super(popupDialog, layout);
    }

    private void init() {
        if (this.actionButtonCornerRadius != null) {
            this.actionButtonTopLeftCornerRadius = this.actionButtonCornerRadius;
            this.actionButtonTopRightCornerRadius = this.actionButtonCornerRadius;
            this.actionButtonBottomRightCornerRadius = this.actionButtonCornerRadius;
            this.actionButtonBottomLeftCornerRadius = this.actionButtonCornerRadius;
        }
        else {
            this.actionButtonTopLeftCornerRadius = this.actionButtonTopLeftCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
            this.actionButtonTopRightCornerRadius = this.actionButtonTopRightCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
            this.actionButtonBottomRightCornerRadius = this.actionButtonBottomRightCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
            this.actionButtonBottomLeftCornerRadius = this.actionButtonBottomLeftCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
        }
    }

    public PopupDialog build(StatusDialogActionListener listener) {
        init();
        if (lottieRaw == null && lottieAsset == null) throw new PopupDialogException("Lottie raw or asset animation is required");
        if (heading == null) throw new PopupDialogException("Standard dialog heading is null");
        if (description == null)
            throw new PopupDialogException("Standard dialog description is null");

        if (this.actionButtonBackground != null) {
            ((DialogStatusBinding) binding).btnDismiss.setBackgroundResource(this.actionButtonBackground);
        }
        else if (this.actionButtonBackgroundColor != null) {
            GradientDrawable shape = getBackground(
                    actionButtonBackgroundColor,
                    actionButtonTopLeftCornerRadius,
                    actionButtonTopRightCornerRadius,
                    actionButtonBottomLeftCornerRadius,
                    actionButtonBottomRightCornerRadius
            );

            if (this.actionButtonRippleColor != null) ((DialogStatusBinding) binding).btnDismiss.setBackground(getRipple(shape, this.actionButtonRippleColor));
            else ((DialogStatusBinding) binding).btnDismiss.setBackground(shape);
        }

        actionButtonText = actionButtonText == null ? "Submit" : actionButtonText;;

        actionButtonTextColor = actionButtonTextColor == null ? super.resToColorInt(R.color.static_white) : actionButtonTextColor;
        headingTextColor = headingTextColor == null ? super.resToColorInt(R.color.colorDarkGrey) : headingTextColor;
        descriptionTextColor = descriptionTextColor == null ? super.resToColorInt(R.color.colorGrey) : descriptionTextColor;

        if (lottieRaw != null) ((DialogStatusBinding) binding).lottieIcon.setAnimation(lottieRaw);
        else if (lottieAsset != null) ((DialogStatusBinding) binding).lottieIcon.setAnimation(lottieAsset);

        if (fontFamily != null) {
            headingFont = fontFamily;
            descriptionFont = fontFamily;
            buttonFont = fontFamily;
        } else {
            headingFont = headingFont == null ? resToTypeface(R.font.bold) : headingFont;
            descriptionFont = descriptionFont == null ? resToTypeface(R.font.regular) : descriptionFont;
            buttonFont = buttonFont == null ? resToTypeface(R.font.medium) : buttonFont;
        }

        headingFontSize = headingFontSize == null ? DEFAULT_HEADING_FONT_SIZE : headingFontSize;
        descriptionFontSize = descriptionFontSize == null ? DEFAULT_DESCRIPTION_FONT_SIZE : descriptionFontSize;
        buttonFontSize = buttonFontSize == null ? DEFAULT_BUTTON_FONT_SIZE : buttonFontSize;

        ((DialogStatusBinding) binding).btnDismiss.setTypeface(buttonFont);
        ((DialogStatusBinding) binding).tvHeading.setTypeface(headingFont);
        ((DialogStatusBinding) binding).tvDescription.setTypeface(descriptionFont);
        ((DialogStatusBinding) binding).btnDismiss.setTextSize(buttonFontSize);
        ((DialogStatusBinding) binding).tvHeading.setTextSize(headingFontSize);
        ((DialogStatusBinding) binding).tvDescription.setTextSize(descriptionFontSize);

        if (background != null) {
            backgroundColor = null;
            backgroundCornerRadius = null;
        }
        else if (backgroundColor != null) {
            if (backgroundCornerRadius != null) {
                backgroundTopLeftCornerRadius = backgroundCornerRadius;
                backgroundTopRightCornerRadius = backgroundCornerRadius;
                backgroundBottomLeftCornerRadius = backgroundCornerRadius;
                backgroundBottomRightCornerRadius = backgroundCornerRadius;
            }
            else {
                backgroundTopLeftCornerRadius = dimenToFloat(R.dimen.dp_5);
                backgroundTopRightCornerRadius = dimenToFloat(R.dimen.dp_5);
                backgroundBottomLeftCornerRadius = dimenToFloat(R.dimen.dp_5);
                backgroundBottomRightCornerRadius = dimenToFloat(R.dimen.dp_5);
            }
        }

        ((DialogStatusBinding) binding).setDialog(super.getDialog());
        ((DialogStatusBinding) binding).setListener(listener);
        ((DialogStatusBinding) binding).setItem(
                new StatusDialogData(
                        heading,
                        description,
                        headingTextColor,
                        descriptionTextColor,
                        actionButtonTextColor,
                        actionButtonText
                )
        );

        return super.getPopupDialog();
    }

    protected T setLottieIcon(@NonNull @RawRes Integer lottieRaw) {
        this.lottieRaw = lottieRaw;
        return castType();
    }

    protected T setLottieIcon(@NonNull String lottieAsset) {
        this.lottieAsset = lottieAsset;
        return castType();
    }

    public T setHeading(String heading) {
        this.heading = heading;
        return castType();
    }

    public T setDescription(String description) {
        this.description = description;
        return castType();
    }

    public T setActionButtonText(String actionButtonText) {
        this.actionButtonText = actionButtonText;
        return castType();
    }

    public T setHeadingTextColor(@NonNull @ColorRes Integer headingTextColor) {
        this.headingTextColor = headingTextColor;
        return castType();
    }

    public T setDescriptionTextColor(@NonNull @ColorRes Integer descriptionTextColor) {
        this.descriptionTextColor = descriptionTextColor;
        return castType();
    }

    public T setActionButtonTextColor(@NonNull @ColorRes Integer actionButtonTextColor) {
        this.actionButtonTextColor = actionButtonTextColor;
        return castType();
    }

    public T setBackground(@NonNull @DrawableRes Integer background) {
        this.background = background;
        return castType();
    }

    public T setBackgroundColor(@NonNull @ColorRes Integer backgroundColor) {
        this.backgroundColor = backgroundColor;
        return castType();
    }

    public T setBackgroundCornerRadius(@NonNull Float backgroundCornerRadius) {
        this.backgroundCornerRadius = backgroundCornerRadius;
        return castType();
    }

    public T setDismissButtonRippleColor(@NonNull @ColorRes Integer dismissButtonRippleColor) {
        this.actionButtonRippleColor = dismissButtonRippleColor;
        return castType();
    }

    public T setBackgroundCornerRadius(
            @NonNull Float topLeft,
            @NonNull Float topRight,
            @NonNull Float bottomLeft,
            @NonNull Float bottomRight) {
        this.backgroundTopLeftCornerRadius = topLeft;
        this.backgroundTopRightCornerRadius = topRight;
        this.backgroundBottomLeftCornerRadius = bottomLeft;
        this.backgroundBottomRightCornerRadius = bottomRight;

        return castType();
    }

    public T setActionButtonBackground(@NonNull @DrawableRes Integer actionButtonBackground) {
        this.actionButtonBackground = actionButtonBackground;
        return castType();
    }

    public T setActionButtonBackgroundColor(@NonNull @DrawableRes Integer actionButtonBackgroundColor) {
        this.actionButtonBackgroundColor = actionButtonBackgroundColor;
        return castType();
    }

    public T setActionButtonCornerRadius(@NonNull Float actionButtonCornerRadius) {
        this.actionButtonCornerRadius = actionButtonCornerRadius;
        return castType();
    }

    public T setActionButtonCornerRadius(@NonNull Float topLeft, @NonNull Float topRight, @NonNull Float bottomLeft, @NonNull Float bottomRight) {
        this.actionButtonTopLeftCornerRadius = topLeft;
        this.actionButtonTopRightCornerRadius = topRight;
        this.actionButtonBottomLeftCornerRadius = bottomLeft;
        this.actionButtonBottomRightCornerRadius = bottomRight;
        return castType();
    }

    public T setFontFamily(@NonNull @FontRes Integer fontFamily) {
        this.fontFamily = resToTypeface(fontFamily);
        return castType();
    }

    public T setHeadingFont(@NonNull @FontRes Integer headingFont) {
        this.headingFont = resToTypeface(headingFont);
        return castType();
    }

    public T setDescriptionFont(@NonNull @FontRes Integer descriptionFont) {
        this.descriptionFont = resToTypeface(descriptionFont);
        return castType();
    }

    public T setButtonFont(@NonNull @FontRes Integer buttonFont) {
        this.buttonFont = resToTypeface(buttonFont);
        return castType();
    }

    public T setHeadingFontSize(@NonNull Float headingFontSize) {
        this.headingFontSize = headingFontSize;
        return castType();
    }

    public T setDescriptionFontSize(@NonNull Float descriptionFontSize) {
        this.descriptionFontSize = descriptionFontSize;
        return castType();
    }

    public T setButtonFontSize(@NonNull Float buttonFontSize) {
        this.buttonFontSize = buttonFontSize;
        return castType();
    }

    private Typeface resToTypeface(@NonNull @FontRes Integer font) {
        return ResourcesCompat.getFont(super.getContext(), font);
    }

    @SuppressWarnings("unchecked")
    protected T castType() {
        return (T) this;
    }
}
