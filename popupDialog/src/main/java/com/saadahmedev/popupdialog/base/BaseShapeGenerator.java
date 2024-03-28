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

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;

import androidx.annotation.ColorRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;

import com.saadahmedev.popupdialog.PopupDialog;

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
        shape.setColor(ContextCompat.getColor(super.getContext(), backgroundColor));
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
                ColorStateList.valueOf(ContextCompat.getColor(super.getContext(), rippleColor)),
                shape,
                null
        );
    }

    protected float dimenToFloat(Integer dimen) {
        return super.getContext().getResources().getDimension(dimen);
    }
}
