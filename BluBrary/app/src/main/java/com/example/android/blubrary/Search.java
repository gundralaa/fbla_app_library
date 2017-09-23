 
//probably missing package statements or something -Tom
//import com.sun.istack.internal.FinalArrayList;

//import java.awt.print.Book;

import java.util.ArrayList;

/**
 * Created by win8demo on 9/20/2017.
 * made with love
 */
public class Search {
    public static ArrayList<Book> search(Book[] library, String searched_title) {
        ArrayList<Book> tempReturn = new ArrayList<>();
        searched_title = searched_title.toUpperCase();

        for (Book aLibrary : library) {
            if (aLibrary.getTitle().toUpperCase().contains(searched_title)) {
                tempReturn.add(aLibrary);
            }
        }
        return tempReturn;
    }

    public static ArrayList<Book> search(Book[] library, String searched_title, String searched_author) {
        searched_author = searched_author.toUpperCase();
        searched_title = searched_title.toUpperCase();
        ArrayList<Book> tempReturn = new ArrayList<>();
        for (Book aLibrary : library) {
            if (aLibrary.getTitle.toUpperCase().contains(searched_title) && aLibrary.getAuthor().toUpperCase().contains(searched_author)) {
                tempReturn.add(aLibrary);
            }
        }
        return tempReturn;
    }

    public static ArrayList<Book> search(Book[] library, String searched_title, String searched_author, String searched_genre) {
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
        return tempReturn;
    }

    public static ArrayList<Book> search(Book[] library, String searched_title, String searched_author, String searched_genre, boolean avaible) {
        searched_author = searched_author.toUpperCase();
        searched_title = searched_title.toUpperCase();
        searched_genre = searched_genre.toUpperCase();
        ArrayList<Book> tempReturn = new ArrayList<>();
        StringBuilder g;
        int i1 = 0;
        while (i1 < library.length) {
            Book aLibrary = library[i1];
            g = new StringBuilder();
            for (int i = 0; i < aLibrary.getGenres().length; i++) {
                g.append(aLibrary.getGenres()[i]);
            }
            if (aLibrary.isCheckedOut() == avaible && aLibrary.getTitle().toUpperCase().contains(searched_title) && aLibrary.getAuthor().toUpperCase().contains(searched_author) && g.toString().toUpperCase().toUpperCase().contains(searched_genre)) {
                tempReturn.add(aLibrary);
            }
            i1++;
        }
        return tempReturn;
    }
}