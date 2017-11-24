package com.example.android.blubrary;

import java.util.ArrayList;

/**
 * Created by saeli on 9/29/2017. <3
 */

public class User {
    public ArrayList<Book> reserved;
    public ArrayList<Book> checkedOut;
    private String username;
    private String password;

    User(String username, String password, String[] reserved, Book[] usrLib) {
        this.username = username;
        this.password = password;
        this.reserved = new ArrayList<>();
        this.checkedOut = new ArrayList<Book>();
        //for (String x: reserved) {
        //    this.reserved.add(x);
        //}
        //for (String x: checkedOut) {
        //    this.checkedOut.add(x);
        //}
    }

    //public String[] getReserved() {
    //    String[] output = new String[reserved.size()];
    //    int curr = 0;
    //    for (String x: reserved) {
    //        output[curr] = x;
    //        curr++;
    //    }
    //    return output;
    //}

    String getPassword() {
        return password;
    }

    String getUsername() {
        return username;
    }

    public String getCheckedOut() {
        String output = "X";
        for (int i = 0; i < checkedOut.size(); i++) {
            output += checkedOut.get(i) + "X";
            // Log.d("oupt", output);
        }
        return output;
    }

    public Book[] cBooks() {
        Book[] outBook = new Book[checkedOut.size()];
        for (int i = 0; i < checkedOut.size(); i++) {
            outBook[i] = checkedOut.get(i);
            // Log.d("outBook:", outBook[i].getTitle());
            // Log.d("checkedOut:", checkedOut.get(i).getTitle());
        }
        //  Log.d("POS", String.valueOf(outBook.length));
        // Log.d("POS", this.getUsername());
        Resources.setUserBooks(outBook);
        return outBook;
    }


    public boolean[] has(Book book) {
        boolean[] output = {false, false}; // corresponds to having the book, and having it checked out (true) or reserved (false)
        if (checkedOut.contains(book.getCallNumber())) {
            output[0] = true;
            output[1] = true;
            return output;
        } else if (reserved.contains(book.getCallNumber())) {
            output[0] = true;
            output[1] = false;
            return output;
        } else {
            return output;
        }
    }

    public void returnBook(Book book) {
        for (int i = 0; i < checkedOut.size(); i++) {
            if (checkedOut.get(i).equals(book)) {
                checkedOut.get(i).setCheckedOut(false);
                checkedOut.remove(i);
                Resources.setUserBooks(Book.arrayListToArray(checkedOut));
                break;
            }
        }
    }

    public void cancelHoldBook(Book book) {
        for (int i = 0; i < checkedOut.size(); i++) {
            if (reserved.get(i).equals(book)) {
                reserved.get(i).held_line.remove(this);

                reserved.remove(i);

                break;
            }
        }
    }

    // will attempt to reserve/unreserve a book for a user, will return true if successful, false if failed (book already reserved or unreserved)
    public boolean reserve(Book book, boolean reserving) { // if true, you are reserving, if false, you are unreserving
        if (reserving) {
            // if checked out or reserved, you can't reserve it
            if (book.isCheckedOut() || book.isReserved()) {
                return false;
            } else {
                book.setReserved(true);
                this.reserved.add(book);
                return true;
            }
        } else {
            // in order for a user to unreserve, they must have the book reserved.. there is some redundancy but it's ok
            if (book.isReserved() && this.reserved.contains(book.getCallNumber())) {
                book.setReserved(false);
                this.reserved.remove(book.getCallNumber());
                return true;
            } else {
                return false;
            }
        }
    }

    public Book[] getUserHolds() {
        return Book.arrayListToArray(reserved);
    }

    public void addToHolds(Book book) {
        if (!reserved.contains(book)) {
            reserved.add(book);
        }
    }

    // will attempt to check a book out or return it... will return true if successful
    public boolean checkOut(Book book, boolean checkingOut) { // checkingOut = true if you want to check out... obvi
        if (checkingOut) {
            // if book is checked out or is reserved not by you, then you can't check it out
            if (book.isCheckedOut() || (book.isReserved() && !(this.reserved.contains(book.getCallNumber())))) {
                return false;
            } else {
                book.setCheckedOut(true);
                this.checkedOut.add(book);
                Resources.setUserBooks(cBooks());

                return true;
            }
        } else {
            // if book is checked out by you
            if (book.isCheckedOut() && this.checkedOut.contains(book.getCallNumber())) {
                book.setCheckedOut(false);
                this.checkedOut.remove(book.getCallNumber());
                return true;
            } else {
                return false;
            }

        }
    }
}
