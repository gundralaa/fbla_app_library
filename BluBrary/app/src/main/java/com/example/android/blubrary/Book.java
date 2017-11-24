package com.example.android.blubrary;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by saeli on 9/20/2017.
 * Book class with attributes
 */

class Book {
    ArrayList<User> held_line = new ArrayList<User>();
    // 14 character call number
    private String callNumber;
    private int daysUntilDue;
    private String title;
    private String author;
    private String[] genre;
    private String pictureFile; // wherever the picture is in the local filesystem
    private int shelfNumber;

    // c and sn are a boolean and int, respectively
    Book(String cn, String dud, String t, String a, String g, String pf, String sn) {
        this.callNumber = cn;
        this.daysUntilDue = Integer.parseInt(dud);
        this.title = t;
        this.author = a;
        this.genre = g.split("/");
        this.pictureFile = pf;
        //this.shelfNumber = Integer.parseInt(sn);
    }

    // should be called when first adding a book, or when updating the book
    // will overwrite any previous version of the book
    private void saveBook() throws Exception {
        java.io.File saveFile = null;
        BufferedWriter writer = null;
        Scanner counter = null;
        Scanner reader = null;
        String[] allLines;
        String concatGenres = "";
        for (int i = 0; i < this.genre.length; i++) {
            if (i == this.genre.length - 1) {
                concatGenres += this.genre[i];
            } else {
                concatGenres += this.genre[i] + "/";
            }
        }
        String thisAsLine = this.callNumber + "#" + this.daysUntilDue + "#" + this.title + "#" + this.author + "#" + concatGenres + "#" + this.pictureFile + "#" + this.shelfNumber;
        boolean exists = false; // if book already exists, there is no need to append to the file
        saveFile = new java.io.File("BookData.txt");
        counter = new Scanner(saveFile);
        // get line count
        int lineCount = 0;
        while (counter.hasNextLine()) {
            counter.nextLine();
            lineCount++;
        }
        counter.close();
        reader = new Scanner(saveFile);
        allLines = new String[lineCount];
        for (int i = 0; i < lineCount; i++) {
            allLines[i] = reader.nextLine();
        }

        for (int i = 0; i < allLines.length; i++) {
            if (allLines[i].split("#")[0].equals(this.callNumber)) {
                allLines[i] = thisAsLine;
                exists = true;
            }
        }
        counter.close();
        // open new filewriter, turning the file into a blank file
        writer = new BufferedWriter(new FileWriter(saveFile));

        // write all the old data (or possibly updated) into the file
        for (int i = 0; i < allLines.length; i++) {
            writer.write(allLines[i]);
            if (i != allLines.length - 1) {
                writer.newLine();
            }
        }

        if (!(exists) && allLines.length > 0) {
            writer.newLine();
            writer.write(thisAsLine);
        } else if (!(exists)) {
            writer.write(thisAsLine);
        }
        writer.close();
    }

    public boolean isCheckedOut() {
        return this.daysUntilDue <= 20;
    }

    public void setCheckedOut(boolean x) {
        if (x) {
            this.daysUntilDue = 20;
        } else {
            this.daysUntilDue = 999;
        }
        //this.saveBook();
    }

    public boolean isCheckedOutToUser(User usr) {
        return usr.has(this)[0] && usr.has(this)[1];
    }

    public boolean isHeldByUser(User usr) {
        return usr.has(this)[0] && usr.has(this)[1];
    }

    public void hold() {
        if (!held_line.contains(Resources.usr)) {
            held_line.add(Resources.usr);
            Resources.usr.addToHolds(this);
        }
    }

    public boolean isReserved() {
        return this.daysUntilDue <= 40 && !(this.isCheckedOut());
    }

    public void setReserved(boolean y) {
        if (y) {
            this.daysUntilDue = 40;
        } else {
            this.daysUntilDue = 999;
        }
    }

    public int checkTim() {
        return this.daysUntilDue;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isOverdue() {
        return this.daysUntilDue <= 0;
    }

    String getAuthor() {
        return this.author;
    }

    public String[] getGenres() {
        return this.genre;
    }

    public String getCallNumber() {
        return this.callNumber;
    }

    public String getPictureFile() {
        return this.pictureFile;
    }

    public int getShelfNumber() {
        return this.shelfNumber;
    }
}