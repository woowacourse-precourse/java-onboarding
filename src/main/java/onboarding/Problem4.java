package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return convertToString(word);
    }

    public static String convertToString(String word) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            result.append(frogDict(ch));
        }
        return result.toString();
    }

    public static char frogDict(char ch) {
        if (Character.isLowerCase(ch)) {
            return (char) ('z' - (ch - 'a'));
        }
        if (Character.isUpperCase(ch)) {
            return (char) ('Z' - (ch - 'A'));
        }
        return ch;
    }
}
