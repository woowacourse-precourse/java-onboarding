package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] chars = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            chars[i] = convertIntoFrogChar(c);
        }

        return new String(chars);
    }

    public static char convertIntoFrogChar(char c) {
        if (!Character.isAlphabetic(c)) {
            return c;
        }

        char converted;

        if (Character.isUpperCase(c)) {
            converted = (char) ('A' + 'Z' - c);

        } else {
            converted = (char) ('a' + 'z' - c);
        }

        return converted;
    }


}
