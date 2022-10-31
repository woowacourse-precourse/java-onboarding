package onboarding;

public class Problem4 {
    public static char convertAlpha(char alpha, boolean isLower) {
        int MAX_LOWER = 'a' + 'z';
        int MAX_UPPER = 'A' + 'Z';
        int alphaInt;

        alphaInt = isLower ? MAX_LOWER - (int)alpha : MAX_UPPER - (int)alpha;
        return (char)alphaInt;
    }

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (char alpha : word.toCharArray()) {
            if (Character.isUpperCase(alpha))
                answer.append(convertAlpha(alpha, false));
            else if (Character.isLowerCase(alpha))
                answer.append(convertAlpha(alpha, true));
            else
                answer.append(alpha);
        }

        return answer.toString();
    }
}
