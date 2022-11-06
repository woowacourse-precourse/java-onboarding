package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if ('a' <= ch && ch <= 'z')
                ch = (char) ('z' - (ch - 'a'));
            else if ('A' <= ch && ch <= 'Z')
                ch = (char) ('Z' - (ch - 'A'));
            sb.replace(i, i + 1, String.valueOf(ch));
        }
        return sb.toString();
    }
}
