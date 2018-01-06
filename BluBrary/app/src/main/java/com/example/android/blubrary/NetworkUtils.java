package com.example.android.blubrary;

import android.graphics.drawable.Drawable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by abhin on 10/5/2017.
 */

public class NetworkUtils{

    public static final String GET_BOOKS_URL = "http://ec2-184-169-219-251.us-west-1.compute.amazonaws.com/getAllBooks.php";

    public static URL makeUrls(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static String getDataFromNetworkHTTP (URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {

            InputStream in = urlConnection.getInputStream();
            Scanner sc = new Scanner(in);
            sc.useDelimiter("\\A");
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

    public static Book[] jsonBookParser(String jsonIn) throws JSONException{
        User[] users = UserObjects.getUsers();
        JSONArray books = new JSONArray(jsonIn);

        Book[] lib = new Book[books.length()];

        for (int i = 0; i < books.length(); i++){
            JSONObject book = books.getJSONObject(i);

            String id = book.getString("id");
            String title = book.getString("title");
            String author = book.getString("author");
            String genre = book.getString("genre");
            String daysTillDue = book.getString("daysTillDue");
            String userId = book.getString("userId");
            String shelfNumber = book.getString("callNumber");
            if(daysTillDue.equals("0")){
                daysTillDue = "999";
            }

            lib[i] = new Book(id,daysTillDue,title,author,genre,"",shelfNumber);
            for (User user: users){
                if (user.getId() == Integer.parseInt(userId)){
                    //user.checkOut(lib[i],true);
                }
            }

        }

        return lib;
    }

    
}
