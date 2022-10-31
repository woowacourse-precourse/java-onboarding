package onboarding;

import java.util.List;

public class Problem4 {
    public static String changeChar(String word, String ans, int i) {
        char c = word.charAt(i);

        if (Character.isAlphabetic(c) && Character.isUpperCase(c)) {
            int pos = c - 'A';
            char temp = (char)('Z' - pos);
            ans = ans + temp;
        } else if (Character.isAlphabetic(c) && Character.isLowerCase(c)) {
            int pos = c - 'a';
            char temp = (char)('z' - pos);
            ans = ans + temp;
        } else {
            ans = ans + c;
        }
        return ans;
    }
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            answer = changeChar(word, answer, i);
        }
        return answer;
    }
}
