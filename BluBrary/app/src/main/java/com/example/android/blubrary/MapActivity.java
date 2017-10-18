package com.example.android.blubrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class MapActivity extends AppCompatActivity {
//keytool -list -v -keystore com.example.android.blubrary
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        WebView wv = (WebView) findViewById(R.id.wview);
        wv.loadUrl("https://goo.gl/maps/uCnUNwhDaGA2");
        //wv.loadUrl("https://maps.googleapis.com/maps/api/staticmap?center=Brooklyn+Bridge,New+York,NY&zoom=13&size=600x300&maptype=roadmap\n" +
        //        "&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318\n" +
        //        "&markers=color:red%7Clabel:C%7C40.718217,-73.998284\n" +
        //        "&key=AIzaSyBmsa85rovv7UsSbCvMOsPXuHgFPbQD9iwn");

    }
}
