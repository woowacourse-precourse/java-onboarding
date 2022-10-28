package onboarding.problem4;

public class AlphabetConverter {
    private static final char MIN_LOWER_CASE = 'a';
    private static final char MAX_LOWER_CASE = 'z';

    private String targetWord;
    private StringBuilder convertedWord;

    public AlphabetConverter(String targetWord) {
        this.targetWord = targetWord;
        convertedWord = new StringBuilder();
    }

    public String convert() {
        for (Character charInWord : targetWord.toCharArray()) {
            if (Character.isLowerCase(charInWord)) {
                convertLowerCase(charInWord);
                continue;
            }
        }
        return convertedWord.toString();
    }

    public void convertLowerCase(char currentChar) {
        convertedWord.append((char) (MAX_LOWER_CASE - currentChar + MIN_LOWER_CASE));
    }
}
