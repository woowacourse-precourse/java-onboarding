package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            answer += reverseAlphabetByAsciiNumber(character);
        }
        return answer;
    }

    private static String reverseAlphabetByAsciiNumber(char character) {
        if (isNotAlphabet(character)) {
            return String.valueOf(character);
        }
        if (Character.isUpperCase(character)) {
            return String.valueOf((char) (155 - character));
        }
        return String.valueOf((char) (219 - character));
    }

    private static boolean isNotAlphabet(char character) {
        return !Character.isAlphabetic(character);
    }
}
