package com.dev.viktorg.soundsofnature.service;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.dev.viktorg.soundsofnature.R;

public class DialogService {
    public static void showFailtureDialog(final Context context, int rightId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View newView = inflater.inflate(R.layout.mylist, null);

        ImageView imageView = (ImageView) newView.findViewById(R.id.icon);
        imageView.setImageResource(rightId);

        builder.setTitle(R.string.wrong_answer)
                .setMessage(R.string.right_answer)
                .setCancelable(false)
                .setView(newView)
                .setNegativeButton(R.string.back_to_menu,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                ((Activity) context).finish();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public static void showSuccesfulDialog(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.win)
                .setCancelable(false)
                .setNegativeButton(R.string.back_to_menu,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                ((Activity) context).finish();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
