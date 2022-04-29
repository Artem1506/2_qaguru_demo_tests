package com.vaulin1506;

import static com.vaulin1506.Utils.*;

public class RandomUtilsTests {
    public static void main(String[] args) {
        System.out.println(getRandomString (5));
        System.out.println(getRandomInt(1, 999));
        System.out.println(getRandomEmail());
    }
}
