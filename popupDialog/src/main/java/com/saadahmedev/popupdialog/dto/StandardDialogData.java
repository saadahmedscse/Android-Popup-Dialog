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

package com.saadahmedev.popupdialog.dto;

public class StandardDialogData extends BaseStandardDialogData {

    private final Integer icon;

    public StandardDialogData(Integer icon, String heading, String description, Integer headingTextColor, Integer descriptionTextColor, Integer positiveButtonTextColor, Integer negativeButtonTextColor, String positiveButtonText, String negativeButtonText) {
        super(heading, description, headingTextColor, descriptionTextColor, positiveButtonTextColor, negativeButtonTextColor, positiveButtonText, negativeButtonText);
        this.icon = icon;
    }


    public Integer getIcon() {
        return icon;
    }
}
