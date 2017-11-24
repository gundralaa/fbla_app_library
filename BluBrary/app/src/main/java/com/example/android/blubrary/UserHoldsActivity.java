package com.example.android.blubrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
public class UserHoldsActivity extends AppCompatActivity implements BookListAdapter.BookListAdapterClickHandler {
    public static Book[] currentLib;
    public User[] users = UserObjects.getUsers();
    public User currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_holds);
        Intent startingIntent = getIntent();
        if (startingIntent.hasExtra("Username")) {
            String username = startingIntent.getStringExtra("Username");
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    currentUser = user;
                }
            }
        }
        Button backbutton = (Button) findViewById(R.id.back);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainac = new Intent(UserHoldsActivity.this, MainActivity.class);
                startActivity(mainac);
            }
        });
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view_books_user);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        Book blankis[] = new Book[0];
        BookListAdapter mBookListAdapter = new BookListAdapter(blankis, UserHoldsActivity.this, currentUser);
        if (Resources.usr.getUserHolds() != null) {
            mBookListAdapter = new BookListAdapter(Resources.usr.getUserHolds(), UserHoldsActivity.this, currentUser);
            int bl[] = new int[Resources.usr.getUserHolds().length];
            for (int i = 1; i < bl.length; i++) {
                //  Log.d("array thing ", String.valueOf(i) + " oh yeah and " + Resources.usr.getUserHolds()[i].getCallNumber());
                bl[i] = Integer.parseInt((Resources.usr.getUserHolds()[i].getCallNumber())) + 1;
                // Log.d("bli", String.valueOf(bl[i]) + 1);
            }
            Resources.setBl(bl);
        }
        mRecyclerView.setAdapter(mBookListAdapter);
    }
    public void onClick(int position, Book lib[]) {
        //Log.d("book click?", "start");
        //Log.d("welp", lib[position].getTitle());
        //Log.d("welp", lib[position].getCallNumber());
        int help_me = Integer.parseInt(lib[position].getCallNumber());
        //Log.d("book click?", String.valueOf(position));
        Context context = UserHoldsActivity.this;
        Class destinationActivity = BookDisplay.class;
        Intent startChildActivityIntent = new Intent(context, destinationActivity);
        //Log.d("blugh", String.valueOf(Resources.getBl()[position]));
        startChildActivityIntent.putExtra("BookPosition", help_me - 1);
        startActivity(startChildActivityIntent);
    }
}
