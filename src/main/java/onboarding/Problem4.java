package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder oppositeWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            oppositeWord.append(translateAlphabet(word.charAt(i)));
        }
        return oppositeWord.toString();
    }

    private static char translateAlphabet(char ch) {
        if ('a' <= ch && ch <= 'z') {
            ch = (char) ('z' - (ch - 'a'));
        } else if ('A' <= ch && ch <= 'Z') {
            ch = (char) ('Z' - (ch - 'A'));
        }
        return ch;
    }
}
