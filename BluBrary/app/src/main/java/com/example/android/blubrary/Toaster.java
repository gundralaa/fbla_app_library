package com.example.android.blubrary;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by pomtree on 10/1/17.
 */

public class Toaster {
    public static void toast(String msg, Context context) {
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
