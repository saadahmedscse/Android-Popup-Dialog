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

package com.saadahmedev.popupdialog.base;

import android.graphics.Typeface;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.ViewDataBinding;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.R;
import com.saadahmedev.popupdialog.exception.PopupDialogException;
import com.saadahmedev.popupdialog.listener.StandardDialogActionListener;

public class BaseStandardDialog<T, VB extends ViewDataBinding> extends BaseShapeGenerator<T, VB> {

    private static final Float DEFAULT_HEADING_FONT_SIZE = 17F;
    private static final Float DEFAULT_DESCRIPTION_FONT_SIZE = 15F;
    private static final Float DEFAULT_BUTTON_FONT_SIZE = 16F;

    protected String heading;
    protected String description;
    protected String negativeButtonText;
    protected String positiveButtonText;
    protected Integer positiveButtonTextColor;
    protected Integer negativeButtonTextColor;
    protected Integer headingTextColor;
    protected Integer descriptionTextColor;
    protected Typeface fontFamily;
    protected Typeface headingFont;
    protected Typeface descriptionFont;
    protected Typeface buttonFont;
    protected Float headingFontSize;
    protected Float descriptionFontSize;
    protected Float buttonFontSize;
    protected Integer background;
    protected Integer backgroundColor;
    protected Float backgroundCornerRadius;
    protected Float backgroundTopLeftCornerRadius;
    protected Float backgroundTopRightCornerRadius;
    protected Float backgroundBottomLeftCornerRadius;
    protected Float backgroundBottomRightCornerRadius;

    protected BaseStandardDialog(PopupDialog popupDialog, @NonNull @LayoutRes Integer layout) {
        super(popupDialog, layout);
    }

    public T setHeading(@NonNull String heading) {
        this.heading = heading;
        return castType();
    }

    public T setDescription(@NonNull String description) {
        this.description = description;
        return castType();
    }

    public T setNegativeButtonText(@NonNull String negativeButtonText) {
        this.negativeButtonText = negativeButtonText;
        return castType();
    }

    public T setPositiveButtonText(@NonNull String positiveButtonText) {
        this.positiveButtonText = positiveButtonText;
        return castType();
    }

    public T setPositiveButtonTextColor(@NonNull @ColorRes Integer positiveButtonTextColor) {
        this.positiveButtonTextColor = positiveButtonTextColor;
        return castType();
    }

    public T setNegativeButtonTextColor(@NonNull @ColorRes Integer negativeButtonTextColor) {
        this.negativeButtonTextColor = negativeButtonTextColor;
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

    public T setBackground(@NonNull @DrawableRes Integer background) {
        this.background = background;
        return castType();
    }

    public T setBackgroundColor(@NonNull @ColorRes Integer backgroundColor) {
        this.backgroundColor = backgroundColor;
        return castType();
    }

    public T setBackgroundCornerRadius(@NonNull Float cornerRadius) {
        this.backgroundCornerRadius = cornerRadius;
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

    public PopupDialog build(StandardDialogActionListener listener) {
        if (heading == null) throw new PopupDialogException("Standard dialog heading is null");
        if (description == null)
            throw new PopupDialogException("Standard dialog description is null");

        positiveButtonText = positiveButtonText == null ? "Submit" : positiveButtonText;
        negativeButtonText = negativeButtonText == null ? "Cancel" : negativeButtonText;

        positiveButtonTextColor = positiveButtonTextColor == null ? super.resToColorInt(R.color.colorDarkGrey) : positiveButtonTextColor;
        negativeButtonTextColor = negativeButtonTextColor == null ? super.resToColorInt(R.color.colorDarkGrey) : negativeButtonTextColor;
        headingTextColor = headingTextColor == null ? super.resToColorInt(R.color.colorDarkGrey) : headingTextColor;
        descriptionTextColor = descriptionTextColor == null ? super.resToColorInt(R.color.colorGrey) : descriptionTextColor;

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
                backgroundTopLeftCornerRadius = backgroundTopLeftCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : backgroundTopLeftCornerRadius;
                backgroundTopRightCornerRadius = backgroundTopRightCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : backgroundTopRightCornerRadius;
                backgroundBottomLeftCornerRadius = backgroundBottomLeftCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : backgroundBottomLeftCornerRadius;
                backgroundBottomRightCornerRadius = backgroundBottomRightCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : backgroundBottomRightCornerRadius;
            }
        }

        return super.getPopupDialog();
    }

    private Typeface resToTypeface(@NonNull @FontRes Integer font) {
        return ResourcesCompat.getFont(super.getContext(), font);
    }

    @SuppressWarnings("unchecked")
    protected T castType() {
        return (T) this;
    }
}
