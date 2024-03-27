package com.saadahmedev.popupdialog.base;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;

import androidx.annotation.ColorRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.base.BaseDialogBinder;

public class BaseShapeGenerator<T, VB extends ViewDataBinding> extends BaseDialogBinder<T, VB> {

    protected BaseShapeGenerator(PopupDialog popupDialog, @NonNull @LayoutRes Integer layout) {
        super(popupDialog, layout);
    }

    protected GradientDrawable getBackground(
            Integer backgroundColor,
            Float topLeft,
            Float topRight,
            Float bottomLeft,
            Float bottomRight) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(backgroundColor);
        shape.setCornerRadii(
                new float[]{
                        topLeft,
                        topLeft,
                        topRight,
                        topRight,
                        bottomRight,
                        bottomRight,
                        bottomLeft,
                        bottomLeft
                }
        );

        return shape;
    }

    protected Integer resToColorInt(@NonNull @ColorRes Integer color) {
        return ContextCompat.getColor(super.getContext(), color);
    }

    protected RippleDrawable getRipple(GradientDrawable shape, Integer rippleColor) {
        return new RippleDrawable(
                ColorStateList.valueOf(rippleColor),
                shape,
                null
        );
    }

    protected float dimenToFloat(Integer dimen) {
        return super.getContext().getResources().getDimension(dimen);
    }
}
