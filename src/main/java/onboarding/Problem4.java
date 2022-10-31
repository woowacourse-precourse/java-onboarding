package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (isUpperCase(c)) {
                sb.append((char) ('A' + 25 - (c - 'A')));
                continue;
            }
            if (isLowerCase(c)) {
                sb.append((char) ('a' + 25 - (c - 'a')));
                continue;
            }

            sb.append(c);
        }
        return sb.toString();
    }

    private static boolean isLowerCase(char c) {
        return c - 'a' >= 0 && c - 'a' < 26;
    }

    private static boolean isUpperCase(char c) {
        return c - 'A' >= 0 && c - 'A' < 26;
    }
}
