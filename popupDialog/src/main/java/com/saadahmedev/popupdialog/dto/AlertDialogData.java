package com.saadahmedev.popupdialog.dto;

public class AlertDialogData extends BaseStandardDialogData {
    public AlertDialogData(String heading, String description, Integer headingTextColor, Integer descriptionTextColor, Integer positiveButtonTextColor, Integer negativeButtonTextColor, String positiveButtonText, String negativeButtonText) {
        super(heading, description, headingTextColor, descriptionTextColor, positiveButtonTextColor, negativeButtonTextColor, positiveButtonText, negativeButtonText);
    }
}
