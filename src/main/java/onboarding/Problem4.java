package onboarding;

public class Problem4 {
    private static final int UPPERCASE_A = 65;
    private static final int LOWERCASE_A = 97;
    private static final int DOUBLE = 2;
    private static final int ALPHABET_COUNT_WITHOUT_A = 25;

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            answer.append(getReverseAlphabet(word.charAt(i)));
        }
        return answer.toString();
    }

    public static char getReverseAlphabet(char alphabet) {
        if (Character.isLowerCase(alphabet)) {
            return getLowerReverseCase(alphabet);
        }
        if (Character.isUpperCase(alphabet)) {
            return getUpperReverseCase(alphabet);
        }
        return alphabet;
    }

    public static char getLowerReverseCase(char alphabet) {
        return (char) (alphabet + (ALPHABET_COUNT_WITHOUT_A - (alphabet - LOWERCASE_A) * DOUBLE));
    }

    public static char getUpperReverseCase(char alphabet) {
        return (char) (alphabet + (ALPHABET_COUNT_WITHOUT_A - (alphabet - UPPERCASE_A) * DOUBLE));
    }
}
