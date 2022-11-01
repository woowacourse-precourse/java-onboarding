package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = decryptString(cryptogram);
        return answer;
    }

    public static String decryptString(String cryptogram) {
        char[] charAry = cryptogram.toCharArray();

        for (int i = 0; i < charAry.length - 1; i++) {
            if (charAry[i] == charAry[i+1]) {
                charAry[i] = ' ';
                charAry[i + 1] = ' ';
            }
        }

        if (cryptogram.equals(new String(charAry))) {
            return cryptogram;
        }

        return decryptString((new String(charAry)).replaceAll(" ", ""));
    }
}
