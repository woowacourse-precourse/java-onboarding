package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = removeDuplicate(cryptogram);

        while (isDuplicate(cryptogram)) {
            cryptogram = removeDuplicate(cryptogram);
        }

        return cryptogram;
    }

    public static boolean isDuplicate(String cryptogram) {
        for (int i = 0; i<cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) return true;
        }
        return false;
    }

    public static String removeDuplicate(String cryptogram) {

        List<String> duplicateCharacters = new ArrayList<>();

        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                duplicateCharacters.add(cryptogram.substring(i, (getCutIndex(cryptogram.substring(i)) + i + 1)));
                i = getCutIndex(cryptogram.substring(i)) + i;
            }
        }

        for (String duplicateCharacter : duplicateCharacters) {
            if (cryptogram.contains(duplicateCharacter))
                cryptogram = cryptogram.replaceAll(duplicateCharacter, "");
        }

        return cryptogram;
    }

    public static int getCutIndex(String str) {
        int cutIndex = 0;

        for (int i = 0; i < str.length() - 1; i++){
            if (str.charAt(i) == str.charAt(i+1) && str.charAt(0) == str.charAt(i)) {
                cutIndex = i+1;
            }
        }
        return cutIndex;
    }
}