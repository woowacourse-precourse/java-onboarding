package onboarding.problem2;

import java.util.HashSet;

public class Duplication {

    public static String reduceDuplication(String cryptogram) {

        HashSet<String> hashSet = new HashSet<>();
        char[] toChar = cryptogram.toCharArray();

        for (char c : toChar) {

            String add = String.valueOf(hashSet.add(String.valueOf(c)));
            add = cryptogram;
        }

        return cryptogram;

    }
}
