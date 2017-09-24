package com.example.android.blubrary;
import java.util.Scanner;
import java.io.File;
/**
 * Created by saeli on 9/20/2017.
 */

// use new BookFetcher().fetch() to get all books in an array
public class BookFetcher {
    // returns all books in database as an array
    public Book[] fetch() throws Exception {
        Book[] output;
        File readFrom = new File("BookData.txt");
        Scanner counter;
        Scanner reader;
        counter = new Scanner(readFrom);
        int lineCount = 0;
        while (counter.hasNextLine()) {
            counter.nextLine();
            lineCount++;
        }
        counter.close();
        output = new Book[lineCount];

        reader = new Scanner(readFrom);
        int index = 0;
        String[] params = new String[7]; // number of attributes of a book
        while (reader.hasNextLine()) {
            params = reader.nextLine().split("#");
            output[index] = new Book(params[0], params[1], params[2], params[3], params[4], params[5], params[6]);
            index++;
        }
        reader.close();
        return output;
    }
}
