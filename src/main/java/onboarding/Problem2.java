package onboarding;

import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    public static String solution(String cryptogram) {


        return removeConsecutive(cryptogram);
    }

    public static String removeConsecutive(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                int lastSameCharacterIdx = i;
                while (lastSameCharacterIdx < s.length() && s.charAt(i - 1) == s.charAt(lastSameCharacterIdx)) {
                    lastSameCharacterIdx++;
                }
                s = s.substring(0, i - 1) + s.substring(lastSameCharacterIdx);
                i = 0;
            }

        }

        return s;
    }
}
