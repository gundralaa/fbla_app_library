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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BookListAdapter.BookListAdapterClickHandler {


    static Book b1 = new Book("9X1QCXE6F7VJY0", "30", "Sycamore Row", "John Grisham", "Law/Fiction", "", "1");
    static Book b2 = new Book("QE6TGXAXSRE340", "30", "The Innocent Man", "John Grisham", "Law/Fiction", "", "1");
    static Book b3 = new Book("WJ3H3XXFW6IMRZ", "15", "The Litigators", "John Grisham", "Law/Fiction", "", "1");
    static Book b4 = new Book("YHZWPN4903UBDP", "15", "People who Changed the Wold", "Barak Obama", "Insiprational/Nonfiction", "", "1");
    static Book b5 = new Book("3SYEG4Q497GXX5", "30", "Living by Chemistry", "Angelica Stacy", "Textbook/Chemistry/Nonfiction", "", "1");
    static Book b6 = new Book("6WDO9ZFHBQ3QAV", "30", "Barron's AP Computer Science A", "Roselyn Teukolsky", "Textbook/Computer Science/Java/AP/Nonfiction", "", "1");
    static Book b7 = new Book("GYWP2Z8YHBVMFS", "15", "The Almanac of American History", "Arthor Bowman", "History/US History/Nonfiction", "", "1");
    static Book b8 = new Book("7V8WG4EJOEFOYM", "999", "The American Pageant", "David Kennedy", "History/US History/Nonfiction/Textbook", "", "1");
    static Book b9 = new Book("0L7WEFCC56R1GP", "999", "Precalculus, 7th edition", "Larson Hostetler", "Math/Textbook/Precalculus", "", "1");
    static Book b10 = new Book("XID4TQAH03XVBF", "999", "Android Programming: The Big Nerd Ranch", "Phillip Marsicano", "Java/Android/App Development", "", "1");
    static Book b11 = new Book("PJ7YQM62VR358V", "999", "AP Economics Macro & Micro", "Princeton Review", "AP/Economics", "", "1");
    static Book b12 = new Book("R7XCFD1S6V7J46", "999", "AP Chemistry", "Princeton Review", "AP/Chemistry", "", "1");
    static Book b13 = new Book("WMCX97YJ64M0J1", "999", "AP U.S. History: Premium ap    Edition", "Princeton Review", "History/US History/Nonfiction/AP", "", "1");
    static Book b15 = new Book("W49B922DJK03PI", "999", "AP World History: Premium Edition", "Princeton Review", "History/US History/Nonfiction/AP", "", "1");
    static Book b14 = new Book("YTHOSN32782943", "999", "AP U.S. History 2017-2018", "Krista Dornbush", "History/US History/Nonfiction/AP", "", "1");
    public static Book[] library = new Book[]{b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15};
    public User pom = new User("Tom","1234", new String[0],new String[0]);
    private RecyclerView mRecyclerView;
    private BookListAdapter mBookListAdapter;
    private EditText titleIn;
    private EditText authorIn;
    private EditText genreIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(int position) {

        Context context = MainActivity.this;

        Class destinationActivity = BookDisplay.class;

        Intent startChildActivityIntent = new Intent(context, destinationActivity);

        startChildActivityIntent.putExtra("BookPosition", position);

        startActivity(startChildActivityIntent);

    }
}
