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

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.saadahmedev.popupdialog.PopupDialog;

public class BaseDialogBinder<T, VB extends ViewDataBinding> extends BaseDialog<T> {

    protected final VB binding;

    protected BaseDialogBinder(PopupDialog popupDialog, @NonNull @LayoutRes Integer layout) {
        super(popupDialog);
        binding = DataBindingUtil.inflate(
                LayoutInflater.from(super.getContext()),
                layout,
                null,
                false
        );
        super.getDialog().setContentView(binding.getRoot());
        assert super.getDialog().getWindow() != null;
        super.getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
}
