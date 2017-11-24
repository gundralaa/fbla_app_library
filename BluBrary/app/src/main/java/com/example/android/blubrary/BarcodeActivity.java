package com.example.android.blubrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
/*

I Robbed this code from https://www.spaceotechnologies.com/qr-code-android-using-zxing-library/
ty for reading my comment
have a nice day

also, here is a gdoc with a bunch of codes coresopding to the Book ID: (hold Ctrl to open link directly)
https://docs.google.com/document/d/19sNX5x3OMO7xnObpW-mYCw2WeevsOkk7Jh_5dJHRNso/edit?usp=sharing



 */


public class BarcodeActivity extends AppCompatActivity {

    View.OnClickListener vocl;
    Book scannedBook;
    String id;
    private Button scanBtn;
    private TextView tvScanFormat, tvScanContent;
    private LinearLayout llSearch;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_barcode);

        scanBtn = (Button) findViewById(R.id.scan_button);

        tvScanFormat = (TextView) findViewById(R.id.tvScanFormat);

        tvScanContent = (TextView) findViewById(R.id.tvScanContent);

        llSearch = (LinearLayout) findViewById(R.id.llSearch);
        Log.d("bc1", "starting integrator");

        scanBtn.setOnClickListener((new View.OnClickListener() {        //this one screws up help (v.2) -Tom
            public void onClick(View v) {
                llSearch.setVisibility(View.GONE);

                Log.d("bc1", "starting integrator");

                IntentIntegrator integrator = new IntentIntegrator(BarcodeActivity.this);

                integrator.setPrompt("Scan a barcode or QRcode");

                integrator.setOrientationLocked(false);

                integrator.initiateScan();

//        Use this for more customization

//        IntentIntegrator integrator = new IntentIntegrator(this);

//        integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);

//        integrator.setPrompt("Scan a barcode");

//        integrator.setCameraId(0);  // Use a specific camera of the device

//        integrator.setBeepEnabled(false);

//        integrator.setBarcodeImageEnabled(true);

//        integrator.initiateScan();

            }
        }));


    }

    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {

            if (result.getContents() == null) {

                llSearch.setVisibility(View.GONE);

                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();

            } else {

                llSearch.setVisibility(View.VISIBLE);

                tvScanContent.setText(result.getContents());

                id = result.getContents();
                scannedBook = Search.getBookByID(id);
                if (scannedBook != null) {
                    Log.d("booK FOUND", scannedBook.getTitle());
                    tvScanFormat.setText(scannedBook.getTitle());
                    Log.d("work you piece of shit", Resources.usr.getUsername());
                    RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view_books_user);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

                    Book blankis[] = new Book[1];
                    blankis[0] = scannedBook;

                    onClick(scannedBook);


                } else {

                    super.onActivityResult(requestCode, resultCode, data);

                }
            }
        }
    }

    public void onClick(Book lib) {
        Log.d("book click?", "start");
        Log.d("welp", lib.getTitle());
        Log.d("welp", lib.getCallNumber());
        int help_me = Integer.parseInt(lib.getCallNumber());
        Log.d("book click?", String.valueOf(0));
        Context context = BarcodeActivity.this;

        Class destinationActivity = BookDisplay.class;

        Intent startChildActivityIntent = new Intent(context, destinationActivity);
        startChildActivityIntent.putExtra("BookPosition", help_me - 1);

        startActivity(startChildActivityIntent);

    }

}