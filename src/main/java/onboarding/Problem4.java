package onboarding;

public class Problem4 {
    public static String solution(String word) {
        validateWordLength(word);

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

    private static void validateWordLength(String word) {
        if (word.length() < 1 || word.length() > 1000) {
            throw new IllegalArgumentException("word의 길이는 1이상 1000이하여야 합니다.");
        }
    }
}
