package com.example.android.blubrary;

/**
 * Created by saeli on 9/29/2017.
 */

public class UserObjects {
    public static User[] getUsers() {
        String[] a = {"9X1QCXE6F7VJY0", "QE6TGXAXSRE340"};
        String[] aa = {"WJ3H3XXFW6IMRZ", "YHZWPN4903UBDP"};
        String[] b = {"3SYEG4Q497GXX5", "6WDO9ZFHBQ3QAV"};
        String[] bb = {"GYWP2Z8YHBVMFS"};
        String[] c = {};
        String[] cc = {};
        Book[] blanks = {};
        return new User[]{
                new User(1,"saelanny", "actuallySaeli", a, aa, blanks),
                new User(2,"test", "test", b, bb, blanks),
                new User(3,"pomtree", "MMMMMMM", c, cc, blanks),
        };
    }
}
