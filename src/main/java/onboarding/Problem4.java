package onboarding;

import java.util.*;

public class Problem4 {
    public static String UPPER_ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String LOWER_ALPHA = "abcdefghijknlmopqrstuvwxyz";
    public static final String TOKEN = UPPER_ALPHA + LOWER_ALPHA + " ";
    public static String solution(String word) {
        Map<Character, Character> alphaMap = new HashMap<>();
        List<Character> originSrc = new ArrayList<>();


        backwardMap(alphaMap);
        splitAlpha(word, originSrc);
        String answer = reverseAlpha(alphaMap,originSrc);

        return answer;
    }

    public static String reverseAlpha(Map<Character, Character> alphaMap, List<Character> originSrc) {
        String reverseResult = "";

        for (Character ch : originSrc) {
            reverseResult += (isAlpha((int) ch)) ? alphaMap.get(ch) : ch;
        }
        return reverseResult;
    }

    public static boolean isAlpha(int chToInt) {
        if (chToInt >= 'A' && chToInt <= 'z') {
            return true;
        }
        return false;
    }

    public static void splitAlpha(String word, List<Character> originSrc) {
        StringTokenizer st = new StringTokenizer(word, TOKEN, true);

        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            originSrc.add(str.charAt(0));
        }
    }

    public static void backwardMap(Map<Character, Character> alphaMap) {
        for (int i = 0; i < 26; i++) {
            alphaMap.put((char) ('A' + i), (char) ('Z' - 1));
            alphaMap.put((char) ('a' + i), (char) ('z' - 1));
        }
    }
}
