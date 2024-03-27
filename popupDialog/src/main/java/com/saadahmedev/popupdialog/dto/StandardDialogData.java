package com.saadahmedev.popupdialog.dto;

public class StandardDialogData extends BaseStandardDialogData {

    private Integer icon;

    public StandardDialogData(Integer icon, String heading, String description, Integer headingTextColor, Integer descriptionTextColor, Integer positiveButtonTextColor, Integer negativeButtonTextColor, String positiveButtonText, String negativeButtonText) {
        super(heading, description, headingTextColor, descriptionTextColor, positiveButtonTextColor, negativeButtonTextColor, positiveButtonText, negativeButtonText);
        this.icon = icon;
    }


    public Integer getIcon() {
        return icon;
    }
}
