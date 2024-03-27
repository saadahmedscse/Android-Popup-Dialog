package com.saadahmedev.popupdialog.dialog.standard;

import android.graphics.drawable.GradientDrawable;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.R;
import com.saadahmedev.popupdialog.base.BaseStandardDialog;
import com.saadahmedev.popupdialog.databinding.DialogStandardBinding;
import com.saadahmedev.popupdialog.dto.StandardDialogData;
import com.saadahmedev.popupdialog.exception.PopupDialogException;
import com.saadahmedev.popupdialog.listener.StandardDialogActionListener;

public class StandardDialog extends BaseStandardDialog<StandardDialog, DialogStandardBinding> {

    private Integer icon;
    private Integer iconColor;
    private Integer positiveButtonBackground;
    private Integer negativeButtonBackground;
    private Integer positiveButtonBackgroundColor;
    private Integer negativeButtonBackgroundColor;
    private Integer positiveButtonRippleColor;
    private Integer negativeButtonRippleColor;
    private Float positiveButtonCornerRadius;
    private Float negativeButtonCornerRadius;
    private Float positiveButtonTopLeftCornerRadius;
    private Float positiveButtonTopRightCornerRadius;
    private Float positiveButtonBottomLeftCornerRadius;
    private Float positiveButtonBottomRightCornerRadius;
    private Float negativeButtonTopLeftCornerRadius;
    private Float negativeButtonTopRightCornerRadius;
    private Float negativeButtonBottomLeftCornerRadius;
    private Float negativeButtonBottomRightCornerRadius;

    private StandardDialog(PopupDialog popupDialog) {
        super(popupDialog, R.layout.dialog_standard);
    }

    public static StandardDialog getInstance(PopupDialog popupDialog) {
        return new StandardDialog(popupDialog);
    }

    private void init() {
        if (this.positiveButtonCornerRadius != null) {
            this.positiveButtonTopLeftCornerRadius = this.positiveButtonCornerRadius;
            this.positiveButtonTopRightCornerRadius = this.positiveButtonCornerRadius;
            this.positiveButtonBottomLeftCornerRadius = this.positiveButtonCornerRadius;
            this.positiveButtonBottomRightCornerRadius = this.positiveButtonCornerRadius;
        }
        else {
            this.positiveButtonTopLeftCornerRadius = this.positiveButtonTopLeftCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
            this.positiveButtonTopRightCornerRadius = this.positiveButtonTopRightCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
            this.positiveButtonBottomLeftCornerRadius = this.positiveButtonBottomLeftCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
            this.positiveButtonBottomRightCornerRadius = this.positiveButtonBottomRightCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
        }
        if (this.negativeButtonCornerRadius != null) {
            this.negativeButtonTopLeftCornerRadius = this.negativeButtonCornerRadius;
            this.negativeButtonTopRightCornerRadius = this.negativeButtonCornerRadius;
            this.negativeButtonBottomLeftCornerRadius = this.negativeButtonCornerRadius;
            this.negativeButtonBottomRightCornerRadius = this.negativeButtonCornerRadius;
        }
        else {
            this.negativeButtonTopLeftCornerRadius = this.negativeButtonTopLeftCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
            this.negativeButtonTopRightCornerRadius = this.negativeButtonTopRightCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
            this.negativeButtonBottomLeftCornerRadius = this.negativeButtonBottomLeftCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
            this.negativeButtonBottomRightCornerRadius = this.negativeButtonBottomRightCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
        }
    }

    @Override
    public PopupDialog build(@NonNull StandardDialogActionListener listener) {
        super.build(listener);
        init();
        if (this.icon == null) throw new PopupDialogException("Standard popup dialog icon cannot be null.");
        if (this.iconColor != null) binding.ivIcon.setColorFilter(ContextCompat.getColor(super.getContext(), iconColor), android.graphics.PorterDuff.Mode.SRC_IN);

        if (this.positiveButtonBackground != null) {
            binding.btnPositive.setBackgroundResource(this.positiveButtonBackground);
        }
        else if (this.positiveButtonBackgroundColor != null) {
            GradientDrawable shape = getBackground(
                    positiveButtonBackgroundColor,
                    positiveButtonTopLeftCornerRadius,
                    positiveButtonTopRightCornerRadius,
                    positiveButtonBottomLeftCornerRadius,
                    positiveButtonBottomRightCornerRadius
            );

            if (this.positiveButtonRippleColor != null) binding.btnPositive.setBackground(getRipple(shape, this.positiveButtonRippleColor));
            else binding.btnPositive.setBackground(shape);
        }

        if (this.negativeButtonBackground != null) {
            binding.btnNegative.setBackgroundResource(this.negativeButtonBackground);
        }
        else if (this.negativeButtonBackgroundColor != null) {
            GradientDrawable shape = getBackground(
                    negativeButtonBackgroundColor,
                    negativeButtonTopLeftCornerRadius,
                    negativeButtonTopRightCornerRadius,
                    negativeButtonBottomLeftCornerRadius,
                    negativeButtonBottomRightCornerRadius
            );

            if (this.negativeButtonRippleColor != null) binding.btnNegative.setBackground(getRipple(shape, this.negativeButtonRippleColor));
            else binding.btnNegative.setBackground(shape);
        }

        binding.btnPositive.setTypeface(super.buttonFont);
        binding.btnNegative.setTypeface(super.buttonFont);
        binding.tvHeading.setTypeface(super.headingFont);
        binding.tvDescription.setTypeface(super.descriptionFont);
        binding.btnPositive.setTextSize(super.buttonFontSize);
        binding.btnNegative.setTextSize(super.buttonFontSize);
        binding.tvHeading.setTextSize(super.headingFontSize);
        binding.tvDescription.setTextSize(super.descriptionFontSize);

        if (super.background != null) {
            binding.rootLayout.setBackgroundResource(super.background);
        }
        else if (super.backgroundColor != null) {
            binding.rootLayout.setBackground(
                    getBackground(
                            super.backgroundColor,
                            super.backgroundTopLeftCornerRadius,
                            super.backgroundTopRightCornerRadius,
                            super.backgroundBottomLeftCornerRadius,
                            super.backgroundBottomRightCornerRadius
                    )
            );
        }

        binding.setDialog(super.getDialog());
        binding.setListener(listener);
        binding.setItem(
                new StandardDialogData(
                        this.icon,
                        super.heading,
                        super.description,
                        super.headingTextColor,
                        super.descriptionTextColor,
                        super.positiveButtonTextColor,
                        super.negativeButtonTextColor,
                        super.positiveButtonText,
                        super.negativeButtonText
                )
        );

        return super.getPopupDialog();
    }

    public StandardDialog setIcon(@NonNull @DrawableRes Integer icon) {
        this.icon = icon;
        return this;
    }

    public StandardDialog setIconColor(@NonNull @ColorRes Integer iconColor) {
        this.iconColor = iconColor;
        return this;
    }

    public StandardDialog setPositiveButtonBackground(@NonNull @DrawableRes Integer positiveButtonBackground) {
        this.positiveButtonBackground = positiveButtonBackground;
        return this;
    }

    public StandardDialog setNegativeButtonBackground(@NonNull @DrawableRes Integer negativeButtonBackground) {
        this.negativeButtonBackground = negativeButtonBackground;
        return this;
    }

    public StandardDialog setPositiveButtonCornerRadius(@NonNull Float positiveButtonCornerRadius) {
        this.positiveButtonCornerRadius = positiveButtonCornerRadius;
        return this;
    }

    public StandardDialog setNegativeButtonCornerRadius(@NonNull Float negativeButtonCornerRadius) {
        this.negativeButtonCornerRadius = negativeButtonCornerRadius;
        return this;
    }

    public StandardDialog setPositiveButtonCornerRadius(
            @NonNull Float topLeft,
            @NonNull Float topRight,
            @NonNull Float bottomLeft,
            @NonNull Float bottomRight
    ) {
        this.positiveButtonTopLeftCornerRadius = topLeft;
        this.positiveButtonTopRightCornerRadius = topRight;
        this.positiveButtonBottomLeftCornerRadius = bottomLeft;
        this.positiveButtonBottomRightCornerRadius = bottomRight;

        return this;
    }

    public StandardDialog setNegativeButtonCornerRadius(
            @NonNull Float topLeft,
            @NonNull Float topRight,
            @NonNull Float bottomLeft,
            @NonNull Float bottomRight
    ) {
        this.negativeButtonTopLeftCornerRadius = topLeft;
        this.negativeButtonTopRightCornerRadius = topRight;
        this.negativeButtonBottomLeftCornerRadius = bottomLeft;
        this.negativeButtonBottomRightCornerRadius = bottomRight;

        return this;
    }

    public StandardDialog setPositiveButtonBackgroundColor(@NonNull @ColorRes Integer positiveButtonBackgroundColor) {
        this.positiveButtonBackgroundColor = positiveButtonBackgroundColor;
        return this;
    }

    public StandardDialog setNegativeButtonBackgroundColor(@NonNull @ColorRes Integer negativeButtonBackgroundColor) {
        this.negativeButtonBackgroundColor = negativeButtonBackgroundColor;
        return this;
    }

    public StandardDialog setPositiveButtonRippleColor(Integer positiveButtonRippleColor) {
        this.positiveButtonRippleColor = positiveButtonRippleColor;
        return this;
    }

    public StandardDialog setNegativeButtonRippleColor(Integer negativeButtonRippleColor) {
        this.negativeButtonRippleColor = negativeButtonRippleColor;
        return this;
    }
}
