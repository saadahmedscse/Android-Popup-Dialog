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

public class BaseStatusDialogData {
    private final String heading;
    private final String description;
    private final Integer headingTextColor;
    private final Integer descriptionTextColor;
    private final Integer actionButtonTextColor;
    private final String actionButtonText;

    public BaseStatusDialogData(String heading, String description, Integer headingTextColor, Integer descriptionTextColor, Integer actionButtonTextColor, String actionButtonText) {
        this.heading = heading;
        this.description = description;
        this.headingTextColor = headingTextColor;
        this.descriptionTextColor = descriptionTextColor;
        this.actionButtonTextColor = actionButtonTextColor;
        this.actionButtonText = actionButtonText;
    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public Integer getHeadingTextColor() {
        return headingTextColor;
    }

    public Integer getDescriptionTextColor() {
        return descriptionTextColor;
    }

    public Integer getActionButtonTextColor() {
        return actionButtonTextColor;
    }

    public String getActionButtonText() {
        return actionButtonText;
    }
}
