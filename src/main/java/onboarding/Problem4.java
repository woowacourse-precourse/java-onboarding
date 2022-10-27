package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder stringBuilder = new StringBuilder(word);
        int alphabetType;
        char letter;
        char convertedLetter;

        for(int i=0; i<stringBuilder.length(); i++) {
            letter = stringBuilder.charAt(i);
            alphabetType = makeAlphabetType(letter);

            if (alphabetType != Constants.NOT_ALPHABET) {
                convertedLetter = convert(letter, alphabetType);
                stringBuilder.setCharAt(i, convertedLetter);
            }
        }

        answer = stringBuilder.toString();
        return answer;
    }

    private static int makeAlphabetType(char letter) {
        if (letter >= 'a' && letter <= 'z') {
            return Constants.LOWERCASE;
        }
        if (letter >= 'A' && letter <= 'Z') {
            return Constants.UPPERCASE;
        }
        return Constants.NOT_ALPHABET;
    }

    private static char convert(char letter, int alphabetType) {
        if (alphabetType == Constants.LOWERCASE) {
            return (char) ('a' + 'z' - letter);
        }
        return (char) ('A' + 'Z' - letter);
    }
}
