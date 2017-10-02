package com.example.android.blubrary;
import java.util.ArrayList;
/**
 * Created by saeli on 9/29/2017.
 */

public class User {
    private String username;
    private String password;
    private ArrayList<String> reserved;
    private ArrayList<String> checkedOut;

    public User(String username, String password, String[] reserved, String[] checkedOut) {
        this.username = username;
        this.password = password;
        this.reserved = new ArrayList<String>();
        this.checkedOut = new ArrayList<String>();
        for (String x: reserved) {
            this.reserved.add(x);
        }
        for (String x: checkedOut) {
            this.checkedOut.add(x);
        }
    }
    public int login_check(String usr, String pw, User[] usrs) {
        for (int i = 0; i < usrs.length; i++) {
            if (usr == usrs[i].getUsername()) {
                if (pw == usrs[i].getPassword()) {
                    //Toaster.toast("loging in", User.this);
                    return i;
                } else {
                    //Toaster.toast("Invalid password", Search.this);
                    return 999;
                }
            }
        }
        //Toaster.toast("Invalid username", Search.this);
        return 999;

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

    public String[] getCheckedOut() {
        String[] output = new String[checkedOut.size()];
        int curr = 0;
        for (String x: checkedOut) {
            output[curr] = x;
            curr++;
        }
        return output;
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}