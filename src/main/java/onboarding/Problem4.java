package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        int strLen = word.length();

        for (int i = 0; i < strLen; i++) {
            verifyChar(word, sb, i);
        }

        return sb.toString();
    }

    private static void verifyChar(String word, StringBuilder sb, int i) {
        Character c = word.charAt(i);

        if (isUpper(c)) {
            sb.append(upperToLower(c));
        } else if (isLower(c)) {
            sb.append(lowerToUpper(c));
        } else {
            sb.append(c);
        }
    }

    private static boolean isUpper(char word) {
        if ((int) word >= 65 && (int) word <= 90) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isLower(char word) {
        if ((int) word >= 97 && (int) word <= 122) {
            return true;
        } else {
            return false;
        }
    }

    private static char upperToLower(char word) {
        return (char)(90 - ((int) word - 65));
    }

    private static char lowerToUpper(char word) {
        return (char)(122 - ((int) word - 97));
    }
}
