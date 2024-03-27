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
