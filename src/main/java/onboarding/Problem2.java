package onboarding;

import net.bytebuddy.pool.TypePool;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String oldCryptogram = cryptogram;
        String newCryptogram = decrypt(cryptogram);
        while (!oldCryptogram.equals(newCryptogram)&&newCryptogram.length()>0) {
            oldCryptogram = newCryptogram;
            newCryptogram = decrypt(newCryptogram);
        }

        return newCryptogram;
    }

    public static String decrypt(String cryptogram) {
        StringBuilder sb = new StringBuilder();
        int n = cryptogram.length();
        if (cryptogram.charAt(0) != cryptogram.charAt(1)) {
            sb.append(cryptogram.charAt(0));
        }
        for (int i = 1; i < n - 1; i++) {
            if (cryptogram.charAt(i) != cryptogram.charAt(i + 1) && cryptogram.charAt(i) != cryptogram.charAt(i - 1)) {
                sb.append(cryptogram.charAt(i));
            }
        }
        if (cryptogram.charAt(n - 1) != cryptogram.charAt(n - 2)) {
            sb.append(cryptogram.charAt(n - 1));
        }
        return sb.toString();
    }

}

