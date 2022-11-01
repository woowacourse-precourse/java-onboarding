package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            answer.append(reverseCharUsingASCII(word.charAt(i)));
        }
        return answer.toString();
    }

    public static String reverseCharUsingASCII(char character) {
        if (isNotAlphabetic(character)) {
            return String.valueOf(character);
        }
        if (Character.isLowerCase(character)) {
            return String.valueOf((char) (122 - character + 97));
        }
        return String.valueOf((char) (90 - character + 65));
    }

    public static boolean isNotAlphabetic(char character) {
        return !Character.isAlphabetic(character);
    }
}

