package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        int strLen = word.length();

        for (int i = 0; i < strLen; i++) {
            Character c = word.charAt(i);

            if ((int) c >= 65 && (int) c <= 90) {
                sb.append(upperToLower(c));
            } else if ((int) c >= 97 && (int) c <= 122) {
                sb.append(lowerToUpper(c));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private static char upperToLower(char word) {
        return (char)(90 - ((int) word - 65));
    }

    private static char lowerToUpper(char word) {
        return (char)(122 - ((int) word - 97));
    }
}
