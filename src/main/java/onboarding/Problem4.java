package onboarding;

import java.util.Stack;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] chArr = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i);
            if ('A' <= c && c <= 'Z') {
                chArr[i] = (char) ('Z' - (c - 'A'));
            } else if ('a' <= c && c <= 'z') {
                chArr[i] = (char) ('z' - (c - 'a'));
            } else {
                chArr[i] = (char) c;
            }
        }
        return answer;
    }
}
