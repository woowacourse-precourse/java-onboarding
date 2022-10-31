package onboarding;

import java.util.zip.ZipEntry;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(getReversedChar(word.charAt(i)));
        }
        return sb.toString();
    }

    public static char getReversedChar(char ch) {
        if ('A' <= ch && ch <= 'Z') {
            return (char)('Z' - ch + 'A');
        }
        if ('a' <= ch && ch <= 'z') {
            return (char)('z' - ch + 'a');
        }
        return ch;
    }
}
