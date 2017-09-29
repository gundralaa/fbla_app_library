package com.example.android.blubrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BookDisplay extends AppCompatActivity {

    TextView mTitleView;
    TextView mAuthorView;
    TextView mGenreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_display);

        mTitleView = (TextView) findViewById(R.id.tv_book_name_more);
        mAuthorView = (TextView) findViewById(R.id.tv_book_author_more);
        mGenreView = (TextView) findViewById(R.id.tv_book_genre_more);
        Intent startingIntent = getIntent();

        if (startingIntent.hasExtra("BookPosition")){
            int bookPosition = startingIntent.getIntExtra("BookPosition", 0);
            Book book = MainActivity.library[bookPosition];
            String title = book.getTitle();
            String author = book.getAuthor();
            String genre = (book.getGenres())[0];
            mTitleView.setText(title);
            mAuthorView.setText(author);
            mGenreView.setText(genre);
        }

    }
}
