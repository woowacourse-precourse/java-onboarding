package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decoding(cryptogram);
    }

    public static String decoding(String cryptogram) {
        char[] cha = cryptogram.toCharArray();
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cha[i] == cha[i + 1]) {
                cryptogram.substring(i, i + 1);
                return decoding(cryptogram.substring(0, i) + cryptogram.substring(i + 2 ,cryptogram.length()));
            }
        }
        return cryptogram;
    }
}
