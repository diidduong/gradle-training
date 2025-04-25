package org.example;

public class StringUtils {
    public static String reverse(String str) {
        String reverse = "";

//        // hard coded
//        for (int i = 0; i < str.length(); i++) {
//            reverse = str.charAt(i) + reverse;
//        }

        reverse = org.apache.commons.lang3.StringUtils.reverse(str);
        return reverse;
    }
}
