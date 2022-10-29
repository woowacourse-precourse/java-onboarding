package onboarding;

public class Problem4 {
    static final int UPPERCASE_A = 65;
    static final int LOWERCASE_A = 97;
    static final int DOUBLE = 2;
    static final int ALPHABET_COUNT_WITHOUT_A = 25;

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            // 로직
        }
        return answer.toString();
    }

    private static char getLowerReverseCase(char alphabet) {
        return (char) (alphabet + (ALPHABET_COUNT_WITHOUT_A - (alphabet - LOWERCASE_A) * DOUBLE));
    }

    private static char getUpperReverseCase(char alphabet) {
        return (char) (alphabet + (ALPHABET_COUNT_WITHOUT_A - (alphabet - UPPERCASE_A) * DOUBLE));
    }
}
