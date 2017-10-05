package com.example.android.blubrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BookListAdapter.BookListAdapterClickHandler {
    
    public static Book [] library = Resources.library;
    public static Book [] currentLib;
    public User pom = new User("Tom", "1234", new String[0], new String[0]);
    public User [] users = UserObjects.getUsers();
    public User currentUser;
    private RecyclerView mRecyclerView;
    private BookListAdapter mBookListAdapter;
    private EditText titleIn;
    private EditText authorIn;
    private EditText genreIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view_books);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(layoutManager);
        titleIn = (EditText) findViewById(R.id.intxt);
        authorIn = (EditText) findViewById(R.id.inauth);
        genreIn = (EditText) findViewById(R.id.ingenre);
        //mBookListAdapter = new BookListAdapter(library);
        //spine = (Spinner)findViewById(R.id.spinz);
        mRecyclerView.setAdapter(mBookListAdapter);
        Button searchButton = (Button) findViewById(R.id.searchB);
        Button buttonReserve = (Button) findViewById(R.id.button_checkout);

        searchButton.setOnClickListener((new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("all goodo", "button.press");
                Log.d("all goodo", titleIn.getText().toString());
                Log.d("all goodo", authorIn.getText().toString());
                Log.d("all goodo", genreIn.getText().toString());
                mBookListAdapter = new BookListAdapter(Search.search(library, titleIn.getText().toString(), authorIn.getText().toString(), genreIn.getText().toString()), MainActivity.this, pom);
                Log.d("all goodo", "button.press passed");
                mRecyclerView.setAdapter(mBookListAdapter);
                Log.d("all goodo", "reset adapter");
            }
        }));

        Intent startingIntent = getIntent();
        if (startingIntent.hasExtra("User")) {
            String username = startingIntent.getStringExtra("User");

            for (User user: users){
                if (user.getUsername().equals(username)){
                    currentUser = user;
                }
            }

        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_map) {

        } else if (id == R.id.nav_virtual_map) {

        } else if (id == R.id.nav_sign_out) {

        } else if (id == R.id.nav_books) {

            Intent startBooksActivityIntent = new Intent(MainActivity.this, UserBooksActivity.class);
            String username = currentUser.getUsername();
            startBooksActivityIntent.putExtra("Username", username);
            startActivity(startBooksActivityIntent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(int position, Book lib []) {

        currentLib = lib;

        Context context = MainActivity.this;

        Class destinationActivity = BookDisplay.class;

        Intent startChildActivityIntent = new Intent(context, destinationActivity);

        startChildActivityIntent.putExtra("BookPosition", position);

        startActivity(startChildActivityIntent);

    }
}
