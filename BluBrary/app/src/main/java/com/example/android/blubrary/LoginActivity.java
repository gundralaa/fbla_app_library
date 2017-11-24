package com.example.android.blubrary;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    EditText usernameField;
    EditText passwordField;
    TextView em;
    Button loginButton;

    User[] users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        users = UserObjects.getUsers();

        usernameField = (EditText) findViewById(R.id.username_text);
        passwordField = (EditText) findViewById(R.id.password_text);
        em = (TextView) findViewById(R.id.errorM);
        em.setVisibility(View.INVISIBLE);
        loginButton = (Button) findViewById(R.id.login_button);

        new GetLibraryData().execute();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User loggedInUser = loginCheck(users, usernameField.getText().toString(), passwordField.getText().toString());
                if (loggedInUser != null) {

                    Context context = LoginActivity.this;
                    Class destinationActivity = MainActivity.class;
                    Intent startChildActivityIntent = new Intent(context, destinationActivity);
                    String username = loggedInUser.getUsername();
                    startChildActivityIntent.putExtra("User", username);
                    startActivity(startChildActivityIntent);

                } else {
                    em.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    private User loginCheck(User[] users, String username, String password) {
        for (User user : users) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public class GetLibraryData extends AsyncTask<Void, Void, Book[]> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Book[] doInBackground(Void... nothing) {
            URL url = NetworkUtils.makeUrls(NetworkUtils.GET_BOOKS_URL);

            try {
                String jsonBooks = NetworkUtils.getDataFromNetworkHTTP(url);
                Book[] lib = NetworkUtils.jsonBookParser(jsonBooks);

                return lib;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Book[] lib) {
            if(lib != null){
                Resources.library = lib;
            }
        }
    }


}
