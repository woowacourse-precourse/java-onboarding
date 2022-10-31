package onboarding.problem4;

public class AlphabetConverter {
    private static final char MIN_LOWER_CASE = 'a';
    private static final char MAX_LOWER_CASE = 'z';
    private static final char MIN_UPPER_CASE = 'A';
    private static final char MAX_UPPER_CASE = 'Z';

    private String targetWord;
    private StringBuilder convertedWord;

    public AlphabetConverter(String targetWord) {
        this.targetWord = targetWord;
        convertedWord = new StringBuilder();
    }

    public String convert() {
        for (Character charInWord : targetWord.toCharArray()) {
            if (!Character.isAlphabetic(charInWord)) {
                appendWithoutConverting(charInWord);
                continue;
            }
            if (Character.isLowerCase(charInWord)) {
                convertLowerCase(charInWord);
                continue;
            }
            if (Character.isUpperCase(charInWord)) {
                convertUpperCase(charInWord);
                continue;
            }
        }
        return convertedWord.toString();
    }

    private void appendWithoutConverting(char currentChar) {
        convertedWord.append(currentChar);
    }

    private void convertLowerCase(char currentChar) {
        convertedWord.append((char) (MAX_LOWER_CASE - currentChar + MIN_LOWER_CASE));
    }

    private void convertUpperCase(char currentChar) {
        convertedWord.append((char) (MAX_UPPER_CASE - currentChar + MIN_UPPER_CASE));
    }
}
