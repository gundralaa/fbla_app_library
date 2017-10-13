package com.example.android.blubrary;
import java.util.ArrayList;
/**
 * Created by saeli on 9/29/2017.
 */

public class User {
    private String username;
    private String password;
    private int id;
    public ArrayList<String> reserved;
    public ArrayList<String> checkedOut;

    public User(int id, String username, String password, String[] reserved, String[] checkedOut) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.reserved = new ArrayList<String>();
        this.checkedOut = new ArrayList<String>();
        for (String x: reserved) {
            this.reserved.add(x);
        }
        for (String x: checkedOut) {
            this.checkedOut.add(x);
        }
    }

    public String[] getReserved() {
        String[] output = new String[reserved.size()];
        int curr = 0;
        for (String x: reserved) {
            output[curr] = x;
            curr++;
        }
        return output;
    }

    public String getPassword() {
        return password;
    }
    public int getId() {return id;}

    public String getUsername() {
        return username;
    }

    public String[] getCheckedOut() {
        String[] output = new String[checkedOut.size()];
        int curr = 0;
        for (String x: checkedOut) {
            output[curr] = x;
            curr++;
        }
        return output;
    }

    public boolean[] has(Book book) {
        boolean[] output = {false, false}; // corresponds to having the book, and having it checked out (true) or reserved (false)
        if (checkedOut.contains(book.getCallNumber())) {
            output[0] = true;
            output[1] = true;
            return output;
        }
        else if (reserved.contains(book.getCallNumber())) {
            output[0] = true;
            output[1] = false;
            return output;
        }
        else {
            return output;
        }
    }

    // will attempt to reserve/unreserve a book for a user, will return true if successful, false if failed (book already reserved or unreserved)
    public boolean reserve(Book book, boolean reserving) { // if true, you are reserving, if false, you are unreserving
        if (reserving) {
            // if checked out or reserved, you can't reserve it
            if (book.isCheckedOut() || book.isReserved()) {
                return false;
            }
            else {
                book.setReserved(true);
                this.reserved.add(book.getCallNumber());
                return true;
            }
        }
        else {
            // in order for a user to unreserve, they must have the book reserved.. there is some redundancy but it's ok
            if (book.isReserved() && this.reserved.contains(book.getCallNumber())) {
                book.setReserved(false);
                this.reserved.remove(book.getCallNumber());
                return true;
            }
            else {
                return false;
            }
        }
    }

    // will attempt to check a book out or return it... will return true if successful
    public boolean checkOut(Book book, boolean checkingOut) { // checkingOut = true if you want to check out... obvi
        if (checkingOut) {
            // if book is checked out or is reserved not by you, then you can't check it out
            if (book.isCheckedOut() || (book.isReserved() && !(this.reserved.contains(book.getCallNumber())))) {
                return false;
            }
            else {
                book.setCheckedOut(true);
                this.checkedOut.add(book.getCallNumber());
                return true;
            }
        }
        else {
            // if book is checked out by you
            if (book.isCheckedOut() && this.checkedOut.contains(book.getCallNumber())) {
                book.setCheckedOut(false);
                this.checkedOut.remove(book.getCallNumber());
                return true;
            }
            else {
                return false;
            }

        }
    }
}
