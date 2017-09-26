package com.example.android.blubrary;

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
        implements NavigationView.OnNavigationItemSelectedListener {
    Book b1 = new Book("1", "99", "Sycamore Row", "John Grisham", "Law/Fiction", "", "1");
    Book b2 = new Book("1", "999", "The Innocent Man", "John Grisham", "Law/Fiction", "", "1");
    Book b3 = new Book("1", "999", "The Litigators", "John Grisham", "Law/Fiction", "", "1");
    Book b4 = new Book("1", "99", "People who Changed the Wold", "Barak Obama", "Insiprational/Nonfiction", "", "1");
    Book b5 = new Book("1", "999", "Living by Chemistry", "Angelica Stacy", "Textbook/Chemistry/Nonfiction", "", "1");
    Book b6 = new Book("1", "999", "Barron's AP Computer Science A", "Roselyn Teukolsky", "Textbook/Computer Science/Java/AP/Nonfiction", "", "1");
    Book b7 = new Book("1", "99", "The Almanac of American History", "Arthor Bowman", "History/US History/Nonfiction", "", "1");
    Book b8 = new Book("1", "999", "The American Pageant", "David Kennedy", "History/US History/Nonfiction/Textbook", "", "1");
    Book b9 = new Book("1", "99", "Precalculus, 7th edition", "Larson Hostetler", "Math/Textbook/Precalculus", "", "1");
    Book b10 = new Book("1", "999", "Android Programming: The Big Nerd Ranch", "Phillip Marsicano", "Java/Android/App Development", "", "1");
    Book b11 = new Book("1", "99", "AP Economics Macro & Micro", "Princeton Review", "AP/Economics", "", "1");
    Book b12 = new Book("1", "99", "AP Chemistry", "Princeton Review", "AP/Chemistry", "", "1");
    Book b13 = new Book("1", "999", "AP U.S. History: Premium ap    Edition", "Princeton Review", "History/US History/Nonfiction/AP", "", "1");
    Book b15 = new Book("1", "99", "AP World History: Premium Edition", "Princeton Review", "History/US History/Nonfiction/AP", "", "1");
    Book b14 = new Book("1", "99", "AP U.S. History 2017-2018", "Krista Dornbush", "History/US History/Nonfiction/AP", "", "1");
    Book[] library = new Book[]{b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15};
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
        searchButton.setOnClickListener((new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("all goodo", "button.press");
                Log.d("all goodo", titleIn.getText().toString());
                Log.d("all goodo", authorIn.getText().toString());
                Log.d("all goodo", genreIn.getText().toString());
                mBookListAdapter = new BookListAdapter(Search.search(library, titleIn.getText().toString(), authorIn.getText().toString(), genreIn.getText().toString()));
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
}
