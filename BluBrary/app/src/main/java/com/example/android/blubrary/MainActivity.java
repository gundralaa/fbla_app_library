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
    static Book b1 = new Book("	1	", "999", "	Sycamore Row	", "	John Grisham	", "	Law/Fiction	", "", "");
    static Book b2 = new Book("	2	", "999", "	The Innocent Man	", "	John Grisham	", "	Law/Fiction	", "", "");
    static Book b3 = new Book("	3	", "999", "	The Litigators	", "	John Grisham	", "	Law/Fiction	", "", "");
    static Book b4 = new Book("	4	", "999", "	People who Changed the Wold	", "	Barak Obama	", "	Insiprational/Nonfiction	", "", "");
    static Book b5 = new Book("	5	", "999", "	Living by Chemistry	", "	Angelica Stacy	", "	Textbook/Chemistry/Nonfiction	", "", "");
    static Book b6 = new Book("	6	", "999", "	Barron's AP Computer Science A	", "	Roselyn Teukolsky	", "	Textbook/Computer Science/Java/AP/Nonfiction	", "", "");
    static Book b7 = new Book("	7	", "999", "	The Almanac of American History	", "	Arthor Bowman	", "	History/US History/Nonfiction	", "", "");
    static Book b8 = new Book("	8	", "999", "	The American Pageant	", "	David Kennedy	", "	History/US History/Nonfiction/Textbook	", "", "");
    static Book b9 = new Book("	9	", "999", "	Precalculus 7th edition	", "	Larson Hostetler	", "	Math/Textbook/Precalculus	", "", "");
    static Book b10 = new Book("	10	", "999", "	Android Programming: The Big Nerd Ranch	", "	Phillip Marsicano	", "	Java/Android/App Development	", "", "");
    static Book b11 = new Book("	11	", "999", "	AP Economics Macro & Micro	", "	Priceton Review	", "	AP/Economics	", "", "");
    static Book b12 = new Book("	12	", "999", "	AP Chemistry	", "	Priceton Review	", "	AP/Chemistry	", "", "");
    static Book b13 = new Book("	13	", "999", "	AP U.S. History: Premium Edition	", "	Priceton Review	", "	History/US History/Nonfiction/AP	", "", "");
    static Book b14 = new Book("	14	", "999", "	AP U.S. History 2017-2018	", "	Krista Dornbush	", "	History/US History/Nonfiction/AP	", "", "");
    static Book b15 = new Book("	15	", "999", "	Big book of Search and find	", "	Jared Tallarico	", "	Kids/Coloring	", "", "");
    static Book b16 = new Book("	16	", "999", "	American Indian Art	", "	Abramas Feder	", "	Native American/Art/Nonfiction	", "", "");
    static Book b17 = new Book("	17	", "999", "	Spartan Gold: A Fargo Adventure	", "	Clive Cussler	", "	Fiction/Historical fiction/adventure	", "", "");
    static Book b18 = new Book("	18	", "77", "	Where the Sidewalk Ends	", "	Shel Silverstien	", "	Poetry/Kids	", "", "");
    static Book b19 = new Book("	19	", "77", "	Statego	", "	Spin Master	", "	Games/War	", "", "");
    static Book b20 = new Book("	20	", "77", "	Mythology	", "	Edith Hamilton	", "	Mythology	", "", "");
    static Book b21 = new Book("	21	", "77", "	Weird Washington	", "	Davis Efarsio	", "	Local/Nonfiction/Maps	", "", "");
    static Book b22 = new Book("	22	", "77", "	The Guiness Railway Book	", "	John Marshall	", "	Records/Nonfiction/Railroading	", "", "");
    static Book b23 = new Book("	23	", "77", "	The Settlers of Catan	", "	Klaus Teuber	", "	Games/History	", "", "");
    static Book b24 = new Book("	24	", "77", "	Washington Middle School 2014-2015	", "	Pual Anders	", "	Yearbook	", "", "");
    static Book b25 = new Book("	25	", "77", "	Olympia High School 2017 Vol. 93	", "	Matt Grant	", "	Yearbook	", "", "");
    static Book b26 = new Book("	26	", "77", "	Cosmopolitain World Atlas	", "	Rand McNally	", "	Atlas/Maps	", "", "");
    static Book b27 = new Book("	27	", "77", "	Great World Atlas	", "	Reader's Digest	", "	Atlas/Maps	", "", "");
    static Book b28 = new Book("	28	", "77", "	Diamonds	", "	Stronghold Games	", "	Games/Stategy	", "", "");
    static Book b29 = new Book("	29	", "77", "	Lost Cities	", "	Rio Grande Games	", "	Games/Cards	", "", "");
    static Book b30 = new Book("	30	", "77", "	Carcassonne	", "	Rio Grande Games	", "	Games/Tile	", "", "");
    static Book b31 = new Book("	31	", "77", "	Ticket To Ride	", "	Alan Moon	", "	Games/Board Games	", "", "");
    static Book b32 = new Book("	32	", "77", "	Book of Warplanes	", "	John Wood	", "	War/Pictures	", "", "");
    static Book b33 = new Book("	33	", "77", "	Star Atlas	", "	Ian Hidpath	", "	Atlas/Astronomy	", "", "");
    static Book b34 = new Book("	34	", "77", "	White Fang	", "	Jack London	", "	Fiction/Adventure	", "", "");
    static Book b35 = new Book("	35	", "999", "	Birds of the Pacific Northwest Coast	", "	Nancy Baron	", "	Birds/Nonfiction	", "", "");
    static Book b36 = new Book("	36	", "999", "	Magic Eye Gallery	", "	Magic Eye Inc.	", "	Optical Illusions	", "", "");
    static Book b37 = new Book("	37	", "999", "	Five acres and Independence	", "	Dover Kairns	", "	Survival/Advice/Nonfiction	", "", "");
    static Book b38 = new Book("	38	", "999", "	America's National Parks and Monuments	", "	Roger Clemenz	", "	Photography	", "", "");
    static Book b39 = new Book("	39	", "999", "	Plants of the Pacific Northwest Coast	", "	Lone Pine	", "	Botany/Nonfiction	", "", "");
    static Book b40 = new Book("	40	", "999", "	Solar Electrity Handbook 2013 Edition	", "	Micheal Boxwell	", "	Solar/Nonfiction	", "", "");
    public static Book[] library = new Book[]{b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,b31,b32,b33,b34,b35,b36,b37,b38,b39,b40};
    public User pom = new User("Tom", "1234", new String[0], new String[0]);
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
