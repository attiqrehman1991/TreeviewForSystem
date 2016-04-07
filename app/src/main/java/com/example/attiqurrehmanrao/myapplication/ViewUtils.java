package com.example.attiqurrehmanrao.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import java.lang.ref.WeakReference;

/**
 * Created by prateekarora on 27/09/15.
 * <p/>
 * Added functions are
 * showCloseAlert      -   Show Dialog - Exit application to confirm from email
 * showLogoutAlert     -   Show Dialog - Remove saved password preferences
 * showSportCloseAlert -   Show Dialog - Exit application
 */
public class ViewUtils {
    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public static void showToast(String message, Context ctx) {
        WeakReference<Context> weakReference = new WeakReference<Context>(ctx);
        Toast.makeText(weakReference.get(), message, Toast.LENGTH_SHORT).show();
    }

    public static void showCloseAlert(final Activity ctx) {
        WeakReference<Context> weakReference = new WeakReference<Context>(ctx);
        new AlertDialog.Builder(weakReference.get())
                .setTitle("Systems")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("Do you realy want to exit?")
                .setPositiveButton(R.string.exit, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        ctx.finish();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        dialog.dismiss();
                    }
                })
//                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public static void showLogoutAlert(final Activity ctx) {
        WeakReference<Context> weakReference = new WeakReference<Context>(ctx);
        new AlertDialog.Builder(weakReference.get())
                .setTitle("Systems")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("Are you sure you want to quit application and log out now?")
                .setPositiveButton(R.string.logout, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        SharedPreferences sharedpreferences = ctx.getSharedPreferences("SystemsPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("email", "");
                        editor.putString("password", "");
                        editor.commit();

                        dialog.dismiss();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        dialog.dismiss();
                    }
                })
//                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public static void showSportCloseAlert(final Activity ctx) {
        WeakReference<Context> weakReference = new WeakReference<Context>(ctx);
        new AlertDialog.Builder(weakReference.get())
                .setTitle("Alert!")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("Kindly set the sports preferences otherwise application will be closed")
                .setPositiveButton(R.string.continu, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(R.string.close, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        ctx.finish();
                        dialog.dismiss();
                    }
                })
//                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public static void showErrorAlert(String message, Context ctx) {
        WeakReference<Context> weakReference = new WeakReference<Context>(ctx);
        new AlertDialog.Builder(weakReference.get())
                .setTitle("Systems")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        dialog.dismiss();
                    }
                })
//                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public static void showSuccessAlert(String message, Context ctx) {
        WeakReference<Context> weakReference = new WeakReference<Context>(ctx);
        new AlertDialog.Builder(weakReference.get())
                .setTitle("Success!")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        dialog.dismiss();
                    }
                })
                .show();
    }

    public static void showAlertDialog(Context context, String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        // Setting Dialog Title
        alertDialog.setTitle(title);

        // Setting Dialog Message
        alertDialog.setMessage(message);

        // Setting alert dialog icon
        alertDialog.setIcon(android.R.drawable.ic_dialog_alert);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }
}
