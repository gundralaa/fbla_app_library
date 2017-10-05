package com.example.android.blubrary;

import java.util.ArrayList;

/**
 * Created by win8demo on 9/20/2017.
 * made with love
 */
public class Search {
    public static Book[] search(Book[] library, String searched_title, String searched_author, String searched_genre) {
        ArrayList<Book> tempReturn = new ArrayList<>();
        searched_author = searched_author.toUpperCase();
        searched_title = searched_title.toUpperCase();
        searched_genre = searched_genre.toUpperCase();
        StringBuilder g;
        int i1 = 0;
        while (i1 < library.length) {
            Book aLibrary = library[i1];
            g = new StringBuilder();
            for (int i = 0; i < aLibrary.getGenres().length; i++) {
                g.append(aLibrary.getGenres()[i]);
            }
            if (aLibrary.getTitle().toUpperCase().contains(searched_title) && aLibrary.getAuthor().toUpperCase().contains(searched_author) && g.toString().toUpperCase().contains(searched_genre)) {
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

}
