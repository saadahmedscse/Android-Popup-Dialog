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

package com.saadahmedev.popupdialog.dialog.progress;

import androidx.annotation.NonNull;
import androidx.annotation.RawRes;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.R;
import com.saadahmedev.popupdialog.base.BaseDialogBinder;
import com.saadahmedev.popupdialog.databinding.DialogLottieBinding;
import com.saadahmedev.popupdialog.dialogType.ProgressTypeDialog;
import com.saadahmedev.popupdialog.exception.PopupDialogException;

public class LottieDialog extends BaseDialogBinder<LottieDialog, DialogLottieBinding> {

    private final ProgressTypeDialog progressTypeDialog;

    private Integer rawRes = null;
    private String asset;
    private Integer repeatCount;
    private Float animationSpeed;

    private LottieDialog(ProgressTypeDialog progressTypeDialog) {
        super(progressTypeDialog.getPopupDialog(), R.layout.dialog_lottie);
        this.progressTypeDialog = progressTypeDialog;
    }

    public static LottieDialog getInstance(ProgressTypeDialog progressTypeDialog) {
        return new LottieDialog(progressTypeDialog);
    }

    public LottieDialog setRawRes(@NonNull @RawRes Integer rawRes) {
        this.rawRes = rawRes;
        return this;
    }

    public LottieDialog setAsset(@NonNull String asset) {
        this.asset = asset;
        return this;
    }

    public LottieDialog setLottieRepeatCount(@NonNull Integer repeatCount) {
        this.repeatCount = repeatCount;
        return this;
    }

    public LottieDialog setLottieAnimationSpeed(@NonNull Float speed) {
        this.animationSpeed = speed;
        return this;
    }

    public PopupDialog build() {
        if (this.rawRes == null && this.asset == null) {
            throw new PopupDialogException("No lottie raw resource or asset file provided");
        }

        if (rawRes != null) {
            asset = null;
            binding.lottieAnimationView.setAnimation(rawRes);
        }
        if (asset != null) binding.lottieAnimationView.setAnimation(asset);
        if (repeatCount != null) binding.lottieAnimationView.setRepeatCount(repeatCount);
        if (animationSpeed != null) binding.lottieAnimationView.setSpeed(animationSpeed);

        return progressTypeDialog.getPopupDialog();
    }
}