package com.saadahmedev.popupdialog.dto;

public class BaseStandardDialogData {
    private String heading;
    private String description;
    private Integer headingTextColor;
    private Integer descriptionTextColor;
    private Integer positiveButtonTextColor;
    private Integer negativeButtonTextColor;
    private String positiveButtonText;
    private String negativeButtonText;

    public BaseStandardDialogData(String heading, String description, Integer headingTextColor, Integer descriptionTextColor, Integer positiveButtonTextColor, Integer negativeButtonTextColor, String positiveButtonText, String negativeButtonText) {
        this.heading = heading;
        this.description = description;
        this.headingTextColor = headingTextColor;
        this.descriptionTextColor = descriptionTextColor;
        this.positiveButtonTextColor = positiveButtonTextColor;
        this.negativeButtonTextColor = negativeButtonTextColor;
        this.positiveButtonText = positiveButtonText;
        this.negativeButtonText = negativeButtonText;
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

    public Integer getPositiveButtonTextColor() {
        return positiveButtonTextColor;
    }

    public Integer getNegativeButtonTextColor() {
        return negativeButtonTextColor;
    }

    public String getPositiveButtonText() {
        return positiveButtonText;
    }

    public String getNegativeButtonText() {
        return negativeButtonText;
    }
}
