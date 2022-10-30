package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int j = 0; j <= word.length() - 1; j++) {
            char c = word.charAt(j);
            answer += reverseConvertChar(c);
        }

        return answer;
    }

    private static char reverseConvertChar(char c) {
        if (Character.isAlphabetic(c) == false) {
            return c;
        } else if (Character.isUpperCase(c)) {
            return (char)(('A' + 'Z') - c);
        } else if (Character.isLowerCase(c)) {
            return (char)(('a' + 'z') - c);
        }

        return c;
    }
}
