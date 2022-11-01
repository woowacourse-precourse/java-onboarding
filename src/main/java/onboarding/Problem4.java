package onboarding;

public class Problem4 {
    public static int DIFFERENCE_OF_UPPER_LOWER = 32;
    public static int CHANGE_REFERENCE_VALUE = 155;

    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < word.length(); index++) {
            sb.append(finalChangeCharacter(word.charAt(index)));
        }
        return sb.toString();
    }

    public static char finalChangeCharacter(char c) {
        if (c >= 'A' && c <= 'Z') {
            return changeCharacter(c);
        } else if (c >= 'a' && c <= 'z') {
            c = changeUpperCase(c);
            char tmp = changeCharacter(c);
            return changeLowerCase(tmp);
        } else {
            return c;
        }
    }

    public static char changeCharacter(char c) {
        return (char) (CHANGE_REFERENCE_VALUE - c);
    }

    public static char changeUpperCase(char c) {
        return (char) (c - DIFFERENCE_OF_UPPER_LOWER);
    }

    public static char changeLowerCase(char c) {
        return (char) (c + DIFFERENCE_OF_UPPER_LOWER);
    }
}
