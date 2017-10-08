package com.example.android.blubrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class UserBooksActivity extends AppCompatActivity implements BookListAdapter.BookListAdapterClickHandler {

    public User[] users = UserObjects.getUsers();
    public User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_books);
        Intent startingIntent = getIntent();
        if (startingIntent.hasExtra("Username")) {
            String username = startingIntent.getStringExtra("Username");
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    currentUser = user;
                }
            }
        }
        Log.d("work you piece of shit", currentUser.getUsername());
//        Log.d("work you piece of shit", String.valueOf(Resources.getUserBooks().length));
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view_books_user);
        BookListAdapter mBookListAdapter = new BookListAdapter(Resources.library, UserBooksActivity.this, currentUser);//replace Resources.library with Resources.getUserBooks or User.cBooks
        mRecyclerView.setAdapter(mBookListAdapter);

    }

    public void onClick(int position, Book lib[]) {

        Context context = UserBooksActivity.this;

        Class destinationActivity = BookDisplay.class;

        Intent startChildActivityIntent = new Intent(context, destinationActivity);

        startChildActivityIntent.putExtra("BookPosition", position);

        startActivity(startChildActivityIntent);

    }
}
