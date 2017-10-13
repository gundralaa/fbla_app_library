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
        User[] output = {
                new User(0,"saelanny", "actuallySaeli", a, aa),
                new User(1,"test", "test", b, bb),
                new User(2,"pomtree", "MMMMMMM", c, cc)
        };
        return output;
    }
}
