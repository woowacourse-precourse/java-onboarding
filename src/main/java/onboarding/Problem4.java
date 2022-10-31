package onboarding;

public class Problem4 {
    private static final int NOT_ALPHABET = 0;
    private static final int LOWERCASE = 1;
    private static final int UPPERCASE = 2;

    public static String solution(String word) {
        String answer = "";
        StringBuilder stringBuilder = new StringBuilder(word);
        int alphabetType;
        char letter;
        char convertedLetter;

        for(int i=0; i<stringBuilder.length(); i++) {
            letter = stringBuilder.charAt(i);
            alphabetType = makeAlphabetType(letter);

            if (alphabetType != NOT_ALPHABET) {
                convertedLetter = convert(letter, alphabetType);
                stringBuilder.setCharAt(i, convertedLetter);
            }
        }

        answer = stringBuilder.toString();
        return answer;
    }

    private static int makeAlphabetType(char letter) {
        if (letter >= 'a' && letter <= 'z') {
            return LOWERCASE;
        }
        if (letter >= 'A' && letter <= 'Z') {
            return UPPERCASE;
        }
        return NOT_ALPHABET;
    }

    private static char convert(char letter, int alphabetType) {
        if (alphabetType == LOWERCASE) {
            return (char) ('a' + 'z' - letter);
        }
        return (char) ('A' + 'Z' - letter);
    }
}
