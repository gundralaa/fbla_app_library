package com.example.android.blubrary;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.net.URL;

public class EntryActivity extends AppCompatActivity {

    private ProgressBar mLoadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        mLoadingIndicator = (ProgressBar) findViewById(R.id.m_loading_bar);

        loadLibraryData();
    }

    private void loadLibraryData() {
        new FetchWeatherTask().execute();
    }

    public class FetchWeatherTask extends AsyncTask<String, Void, Book[]> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingIndicator.setVisibility(View.VISIBLE);
        }

        @Override
        protected Book[] doInBackground(String... params) {

            URL weatherRequestUrl = NetworkUtils.makeUrls(NetworkUtils.GET_BOOKS_URL);

            try {
                String jsonLibraryResponse = NetworkUtils.getDataFromNetworkHTTP(weatherRequestUrl);

                Book[] libraryData = NetworkUtils.jsonBookParser(jsonLibraryResponse);

                return libraryData;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Book[] library) {
            mLoadingIndicator.setVisibility(View.INVISIBLE);
            if (library != null) {
                Resources.library = library;
                Intent startLoginActivityIntent = new Intent(EntryActivity.this, LoginActivity.class);
                startActivity(startLoginActivityIntent);
            } else {
                // No Change to Resources.library
                Intent startLoginActivityIntent = new Intent(EntryActivity.this, LoginActivity.class);
                startActivity(startLoginActivityIntent);

            }
        }
    }


}
