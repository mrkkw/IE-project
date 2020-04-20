package com.example.newgame;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class custom_toast {
    private static TextView mTextView;

    public static void showToast(Context context, CharSequence message) {

        Toast toastStart = new Toast(context);

        //set position
        toastStart.setGravity(Gravity.CENTER_HORIZONTAL, 0, 800);
        toastStart.setDuration(Toast.LENGTH_LONG);

        View toastRoot = LayoutInflater.from(context).inflate(R.layout.toast_layout, null);

        //set layout
        mTextView = (TextView) toastRoot.findViewById(R.id.message);
        toastStart.setView(toastRoot);

        //set message
        mTextView.setText(message);

        //show custom toast
        toastStart.show();
    }
}