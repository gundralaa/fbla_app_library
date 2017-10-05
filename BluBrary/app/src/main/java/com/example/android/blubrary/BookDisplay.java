package com.example.android.blubrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

public class BookDisplay extends AppCompatActivity {

    TextView mTitleView;
    TextView mAuthorView;
    TextView mGenreView;
    TextView mCallView;
    TextView mShelfView;
    //ImageView mCoverArt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_display);

        mTitleView = (TextView) findViewById(R.id.tv_book_name_more);
        mAuthorView = (TextView) findViewById(R.id.tv_book_author_more);
        mGenreView = (TextView) findViewById(R.id.tv_book_genre_more);
        mCallView = (TextView) findViewById(R.id.tv_book_callNum_more);
        mShelfView = (TextView) findViewById(R.id.tv_book_shelfNum_more);
        //mCoverArt = (ImageView) findViewById(R.id.tv_book_cover_art);
        Intent startingIntent = getIntent();

        if (startingIntent.hasExtra("BookPosition")) {
            int bookPosition = startingIntent.getIntExtra("BookPosition", 0);
            final Book book = MainActivity.library[bookPosition];
            final String title = book.getTitle();
            String author = book.getAuthor();
            String genre = "";
            String[] genres = book.getGenres();
            for (int i=0; i<genres.length; i++) {
                if (i==genres.length-1) {
                    genre += genres[i];
                }
                else {
                    genre += (genres[i] + ", ");
                }
            }

            mTitleView.setText(title);
            mAuthorView.setText(author);
            mGenreView.setText(("Genre(s): " + genre));
            mCallView.setText(("Call Number: " + book.getCallNumber()));
            mShelfView.setText(("Shelf # " + book.getShelfNumber()));

        }

    }
}
