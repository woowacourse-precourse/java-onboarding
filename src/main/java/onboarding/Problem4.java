package onboarding;

public class Problem4 {
    private static final char LOWER_A = 'a';
    private static final char LOWER_Z = 'z';
    private static final char UPPER_A = 'A';
    private static final char UPPER_Z = 'Z';

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!isAlphabet(letter)) {
                answer.append(letter);
                continue;
            }
            if (isLowerCase(letter)) {
                answer.append(Character.toString(LOWER_Z - (letter - LOWER_A)));
                continue;
            }
            if (isUpperCase(letter)) {
                answer.append(Character.toString(UPPER_Z - (letter - UPPER_A)));
            }
        }
        return answer.toString();
    }

    private static boolean isAlphabet(char letter) {
        return isLowerCase(letter) || isUpperCase(letter);
    }

    private static boolean isLowerCase(char letter) {
        return letter >= 97 && letter <= 122;
    }

    private static boolean isUpperCase(char letter) {
        return letter >= 65 && letter <= 90;
    }
}
