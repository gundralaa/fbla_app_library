package com.example.android.blubrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UserBooksActivity extends AppCompatActivity {

    public User [] users = UserObjects.getUsers();
    public User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_books);

        Intent startingIntent = getIntent();
        if (startingIntent.hasExtra("Username")) {
            String username = startingIntent.getStringExtra("Username");
            for (User user: users){
                if (user.getUsername().equals(username)){
                    currentUser = user;
                }
            }

        }


    }
}
