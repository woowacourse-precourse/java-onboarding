package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char digit = word.charAt(i);

            if (isBlank(digit)) {
                stringBuilder.append(" ");
                continue;
            }
        }

        return stringBuilder.toString();
    }

    private static boolean isBlank(char digit) {
        return digit == ' ';
    }
}
