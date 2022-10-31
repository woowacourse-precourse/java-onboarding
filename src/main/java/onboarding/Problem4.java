package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (isNonAlphabet(c)) {
                sb.append(c);
                continue;
            }
        }

        return sb.toString();
    }

    private static boolean isNonAlphabet(char c) {
        if (!Character.isLetter(c) || Character.isWhitespace(c)) {
            return true;
        }
        return false;
    }
}