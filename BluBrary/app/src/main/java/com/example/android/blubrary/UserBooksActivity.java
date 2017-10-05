package com.example.android.blubrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

public class UserBooksActivity extends AppCompatActivity {

    public User[] users = UserObjects.getUsers();
    public User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_books);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view_books_user);
        ////BookListAdapter mBookListAdapter = new BookListAdapter(currentUser.cBooks(), MainActivity, currentUser);
        //mRecyclerView.setAdapter(mBookListAdapter);


        Intent startingIntent = getIntent();
        if (startingIntent.hasExtra("Username")) {
            String username = startingIntent.getStringExtra("Username");
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    currentUser = user;
                }
            }

        }


    }

    public void onClick(int position, Book lib[]) {

        Context context = UserBooksActivity.this;

        Class destinationActivity = BookDisplay.class;

        Intent startChildActivityIntent = new Intent(context, destinationActivity);

        startChildActivityIntent.putExtra("BookPosition", position);

        startActivity(startChildActivityIntent);

    }
}
