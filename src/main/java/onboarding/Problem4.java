package onboarding;

public class Problem4 {
    public static String solution(String word) {

        StringBuilder convertedSb = new StringBuilder();

        for (char c : word.toCharArray()) {
            convertedSb.append(convert(c));
        }
        return convertedSb.toString();

    }

    static char convert(char currentChar) {

        if (!isAlphabet(currentChar))
            return currentChar;

        if (Character.isLowerCase(currentChar))
            return (char) ('a' + ('z' - currentChar));

        return (char) ('A' + ('Z' - currentChar));
    }

    static boolean isAlphabet(char c) {

        return ('a' <= c && c <= 'z')
                || ('A' <= c && c <= 'Z');
    }
}
