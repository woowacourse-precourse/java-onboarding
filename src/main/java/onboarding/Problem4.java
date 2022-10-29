package onboarding;

public class Problem4 {

    private static final String STRING_INIT_VARIABLE_VALUE = "";
    private static final int WORD_INDEX_START_NUM = 0;
    private static final int INT_INIT_VARIABLE_VALUE = 0;
    private static final Character FIRST_UPPER_CASE_ALPHABET = 'A';
    private static final Character LAST_UPPER_CASE_ALPHABET = 'Z';
    private static final Character FIRST_LOWER_CASE_ALPHABET = 'a';
    private static final Character LAST_LOWER_CASE_ALPHABET = 'z';
    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR] : ";
    private static final String WRONG_WORD_RANGE_EXCEPTION_MESSAGE = "엄마 말씀은 1 이상 1,000이하의 문자열이어야합니다.";
    private static final int MIN_WORD_LENGTH = 1;
    private static final int MAX_WORD_LENGTH = 1000;

    public static String solution(String momWord) {
        validateWord(momWord);
        return convertWord(momWord);
    }

    private static String convertWord(String word) {
        String convertWord = STRING_INIT_VARIABLE_VALUE;
        for (int wordIndex = WORD_INDEX_START_NUM; wordIndex < word.length(); wordIndex++) {
            char charAtWord = word.charAt(wordIndex);
            if (Character.isAlphabetic(charAtWord)) {
                convertWord += convertAlphabet(charAtWord);
            }
            if (!Character.isAlphabetic(charAtWord)) {
                convertWord += charAtWord;
            }
        }
        return convertWord;
    }

    private static Character convertAlphabet(Character inputCharacter) {
        int calculationNum = getCalculationNumberByAlphabetUpperOrLowerCase(inputCharacter);
        return (char) (calculationNum - inputCharacter);
    }

    private static int getCalculationNumberByAlphabetUpperOrLowerCase(Character alphabet) {
        int calculationNumberByAlphabetUpperOrLowerCase = INT_INIT_VARIABLE_VALUE;
        if (Character.isUpperCase(alphabet)) {
            calculationNumberByAlphabetUpperOrLowerCase = getUpperCaseCalculationNumber();
        }
        if (Character.isLowerCase(alphabet)) {
            calculationNumberByAlphabetUpperOrLowerCase = getLowerCaseCalculationNumber();
        }
        return calculationNumberByAlphabetUpperOrLowerCase;
    }

    private static int getUpperCaseCalculationNumber() {
        return FIRST_UPPER_CASE_ALPHABET + LAST_UPPER_CASE_ALPHABET;
    }

    private static int getLowerCaseCalculationNumber() {
        return FIRST_LOWER_CASE_ALPHABET + LAST_LOWER_CASE_ALPHABET;
    }

    private static void validateWord(String momWord) {
        if(!validateWordRange(momWord)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_PREFIX + WRONG_WORD_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private static boolean validateWordRange(String momWord) {
        return (momWord.length() >= MIN_WORD_LENGTH && momWord.length() <= MAX_WORD_LENGTH);
    }
}