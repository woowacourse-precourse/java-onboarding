package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder oppositeWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            oppositeWord.append(translateLowerCase(word.charAt(i)));
        }
        return oppositeWord.toString();
    }

    private static char translateLowerCase(char ch) {
        if ('a' <= ch && ch <= 'z') {
            ch = (char) ('z' - (ch - 'a'));
        }
        return ch;
    }
}
