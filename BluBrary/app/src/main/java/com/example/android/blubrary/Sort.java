package com.example.android.blubrary;

import android.util.Log;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by pomtree on 10/4/17.
 */

public class Sort {


    public static Book[] sortByTitle(Book[] inLib) {
        Book outLib[] = new Book[inLib.length];
        String demo[] = new String[inLib.length];
        for (int i = 0; i < inLib.length; i++) {
            demo[i] = inLib[i].getTitle();
        }
        Arrays.sort(demo);
        for (int i = 0; i < demo.length; i++) {
            Log.d("please sort", demo[i]);
        }
        for (int i = 0; i < inLib.length; i++) {
            for (int j = 0; j < inLib.length; j++) {
                if (Objects.equals(demo[j], inLib[i].getTitle())) {
                    outLib[j] = inLib[i];
                }
            }
        }


        return outLib;

    }

    public static Book[] sortByAuth(Book[] inLib) {
        Book outLib[] = new Book[inLib.length];
        String demo[] = new String[inLib.length];
        for (int i = 0; i < inLib.length; i++) {
            demo[i] = inLib[i].getAuthor();
        }
        Arrays.sort(demo);
        for (int i = 0; i < inLib.length; i++) {
            for (int j = 0; j < inLib.length; j++) {
                if (Objects.equals(demo[j], inLib[i].getAuthor())) {
                    outLib[j] = inLib[i];
                }
            }
        }


        return outLib;

    }

    //public static Book[] sortByAva(Book[] inLib) {
    //    Book outLib[] = new Book[inLib.length];
    //    String demo[] = new String[inLib.length];
    //    for (int i = 0; i < inLib.length; i++) {
    //        if (inLib[i].isCheckedOut()) demo[i] = "t";
    //        else demo[i] = "f";
    //    }
    //    Arrays.sort(demo);
    //    for (int i = 0; i < inLib.length; i++) {
    //        for (int j = 0; j < inLib.length; j++) {
    //            if (Objects.equals(demo[j], inLib[i].isCheckedOut())) {
    //                outLib[j] = inLib[i];
    //            }
    //        }
    //    }
//
//
    //    return outLib;
//
    //}


}
