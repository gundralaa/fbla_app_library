package com.example.android.blubrary;

import java.util.ArrayList;

/**
 * Created by win8demo on 9/20/2017.
 * made with love
 */
public class Search {
    public static Book[] search(Book[] library, String searched_title, String searched_author) {
        ArrayList<Book> tempReturn = new ArrayList<>();
        searched_author = searched_author.toUpperCase();
        searched_title = searched_title.toUpperCase();
        StringBuilder g;
        int i1 = 0;
        while (i1 < library.length) {
            Book aLibrary = library[i1];
            g = new StringBuilder();

            if (aLibrary.getTitle().toUpperCase().contains(searched_title) && aLibrary.getAuthor().toUpperCase().contains(searched_author)) {
                tempReturn.add(aLibrary);
            }
            i1++;
        }
        Book returnMe[] = new Book[tempReturn.size()];
        for (int i = 0; i < tempReturn.size(); i++) {
            returnMe[i] = tempReturn.get(i);

        }
        return returnMe;

    }

    public static Book getBookByID(String id) {
        for (Book aLibrary : Resources.library) {
            if (aLibrary.getCallNumber().equals(id)) return aLibrary;

        }
        return null;
    }

}
