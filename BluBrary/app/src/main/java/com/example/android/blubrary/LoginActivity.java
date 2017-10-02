package com.example.android.blubrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    public int login_check(String usr, String pw, User[] usrs) {
        for (int check = 0; check < usrs.length; check++) {
            Log.d("USERNAME @ CHECK", usrs[check].getUsername());
            Log.d("USERNAME BOX    ", usr);
            if (Objects.equals(usrs[check].getUsername(), usr)) {
                Log.d("y", "usr pass");
                if (Objects.equals(usrs[check].getPassword(), pw)) {
                    Log.d("y", "pw poass");
                    Toaster.toast("Loging in...", this);
                    return check;
                }
            }
        }
        Toaster.toast("Invalid Username/Password, try again.", this);
        return 999;
    }
}
