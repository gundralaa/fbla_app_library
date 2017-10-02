package com.example.android.blubrary;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText usernameField;
    EditText passwordField;
    Button loginButton;

    User [] users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        users = UserObjects.getUsers();

        usernameField = (EditText) findViewById(R.id.username_text);
        passwordField = (EditText) findViewById(R.id.password_text);

        loginButton = (Button) findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean authorized = loginCheck(users, usernameField.getText().toString(), passwordField.getText().toString());
                if(authorized){
                    Context context = LoginActivity.this;
                    Class destinationActivity = MainActivity.class;
                    Intent startChildActivityIntent = new Intent(context, destinationActivity);
                    startActivity(startChildActivityIntent);
                }
            }
        });


    }
    private boolean loginCheck(User [] users, String username, String password){
        for(User user: users){
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }


}
