package com.example.android.blubrary;

import android.graphics.drawable.Drawable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by abhin on 10/5/2017.
 */

public class NetworkUtils{



    public String getDataFromNetworkHTTP (URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {

            InputStream in = urlConnection.getInputStream();
            Scanner sc = new Scanner(in);
            sc.delimiter();
            if(sc.hasNext()){
                return sc.next();
            }
            else {
                return null;
            }
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
        finally {
            urlConnection.disconnect();
        }

    }

    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }
    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
}
