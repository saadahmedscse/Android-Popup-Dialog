package com.caffeine.popupdialog.util;

import android.app.Dialog;
import android.content.Context;

import com.caffeine.popupdialog.R;
import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.listener.StandardDialogActionListener;
import com.saadahmedev.popupdialog.listener.StatusDialogActionListener;

public class DialogUtil {

    public static void showProgressDialog(Context context) {
        PopupDialog.getInstance(context)
                .progressDialogBuilder()
                .createProgressDialog()
                .setTint(R.color.purple_200)
//                .setCancelable(false)
//                .setTimeout(3000)
                .build()
                .show();
    }

    public static void showLottieDialog(Context context) {
        PopupDialog.getInstance(context)
                .progressDialogBuilder()
                .createLottieDialog()
                .setRawRes(R.raw.success)
                .setCancelable(true)
//                .setTimeout(3000)
                .setLottieAnimationSpeed(3F)
                .setLottieRepeatCount(Integer.MAX_VALUE)
                .build()
                .show();
    }

    public static void showStandardDialog(Context context) {
        PopupDialog.getInstance(context)
                .standardDialogBuilder()
                .createStandardDialog()
                .setHeading("Ping Pong Matchup")
                .setDescription("Challenge a friend to a friendly table tennis duel.")
                .setIcon(R.drawable.ic_table_tenis)
                .setIconColor(R.color.purple_200)
//                .setFontFamily(R.font.cubano)
                .setCancelable(false)

                .setPositiveButtonBackgroundColor(R.color.purple_200)
                .setPositiveButtonCornerRadius(20F)
                .setNegativeButtonBackgroundColor(R.color.purple_500)
                .setNegativeButtonCornerRadius(20F)

                .setPositiveButtonText("Computer")
                .setNegativeButtonText("Friends")
                .setPositiveButtonTextColor(R.color.black)
                .setNegativeButtonTextColor(R.color.white)

                .setPositiveButtonRippleColor(R.color.white)
                .setNegativeButtonRippleColor(R.color.white)

//                .setBackground(R.drawable.bg_blue_10)
//                .setBackgroundColor(R.color.teal_200)
//                .setBackgroundCornerRadius(50F)
//                .setBackgroundCornerRadius(50F, 10F, 10F, 50F)

                .build(new StandardDialogActionListener() {
                    @Override
                    public void onPositiveButtonClicked(Dialog dialog) {
                        dialog.dismiss();
                    }
                    @Override
                    public void onNegativeButtonClicked(Dialog dialog) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    public static void showIOSDialog(Context context) {
        PopupDialog.getInstance(context)
                .standardDialogBuilder()
                .createIOSDialog()
                .setHeading("Ping Pong Matchup")
                .setDescription("Challenge a friend to a friendly table tennis duel.")
//                .setHeadingFont(R.font.cubano)
                .setPositiveButtonText("Computer")
                .setNegativeButtonText("Friends")
                .setPositiveButtonTextColor(R.color.purple_500)
                .setNegativeButtonTextColor(R.color.teal_200)

//                .setBackground(R.drawable.bg_blue_10)
//                .setBackgroundColor(R.color.teal_200)
//                .setBackgroundCornerRadius(50F)
//                .setBackgroundCornerRadius(50F, 10F, 10F, 50F)

                .build(new StandardDialogActionListener() {
                    @Override
                    public void onPositiveButtonClicked(Dialog dialog) {
                        dialog.dismiss();
                    }
                    @Override
                    public void onNegativeButtonClicked(Dialog dialog) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    public static void showAlertDialog(Context context) {
        PopupDialog.getInstance(context)
                .standardDialogBuilder()
                .createAlertDialog()
                .setHeading("Ping Pong Matchup")
                .setDescription("Challenge a friend to a friendly table tennis duel.")
//                .setHeadingFont(R.font.cubano)
                .setPositiveButtonText("Computer")
                .setNegativeButtonText("Friends")
                .setPositiveButtonTextColor(R.color.purple_500)
                .setNegativeButtonTextColor(R.color.teal_200)

//                .setBackground(R.drawable.bg_blue_10)
//                .setBackgroundColor(R.color.teal_200)
//                .setBackgroundCornerRadius(50F)
//                .setBackgroundCornerRadius(50F, 10F, 10F, 50F)

                .build(new StandardDialogActionListener() {
                    @Override
                    public void onPositiveButtonClicked(Dialog dialog) {
                        dialog.dismiss();
                    }
                    @Override
                    public void onNegativeButtonClicked(Dialog dialog) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    public static void showStatusDialog(Context context) {
        PopupDialog.getInstance(context)
                .statusDialogBuilder()
                .createStatusDialog()
                .setLottieIcon(R.raw.success)
                .setHeading("Ping Pong Matchup")
                .setDescription("Challenge a friend to a friendly table tennis duel.")
//                .setHeadingFont(R.font.cubano)
                .setActionButtonText("Play")
                .setActionButtonTextColor(R.color.black)
                .setActionButtonBackgroundColor(R.color.purple_200)
                .setDismissButtonRippleColor(R.color.white)

//                .setBackground(R.drawable.bg_blue_10)
//                .setBackgroundColor(R.color.teal_200)
//                .setBackgroundCornerRadius(50F)
//                .setBackgroundCornerRadius(50F, 10F, 10F, 50F)

                .build(Dialog::dismiss)
                .show();
    }

    public static void showSuccessDialog(Context context) {
        PopupDialog.getInstance(context)
                .statusDialogBuilder()
                .createSuccessDialog()
                .setHeading("Ping Pong Matchup")
                .setDescription("Challenge a friend to a friendly table tennis duel.")
//                .setHeadingFont(R.font.cubano)
                .setActionButtonText("Play")
                .setActionButtonTextColor(R.color.black)
                .setActionButtonBackgroundColor(R.color.purple_200)
                .setDismissButtonRippleColor(R.color.white)

//                .setBackground(R.drawable.bg_blue_10)
//                .setBackgroundColor(R.color.teal_200)
//                .setBackgroundCornerRadius(50F)
//                .setBackgroundCornerRadius(50F, 10F, 10F, 50F)

                .build(Dialog::dismiss)
                .show();
    }
}
