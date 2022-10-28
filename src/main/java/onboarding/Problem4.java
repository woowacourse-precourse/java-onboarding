package onboarding;

public class Problem4 {
    public static String solution(String momWord) {
        validateWord(momWord);
        return convertWord(momWord);
    }

    public static String convertWord(String word) {
        String convertWord = "";
        for (int wordIndex = 0; wordIndex < word.length(); wordIndex++) {
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

    public static Character convertAlphabet(Character inputCharacter) {
        int calculationNum = getCalculationNumberByAlphabetUpperOrLowerCase(inputCharacter);
        return (char) (calculationNum - inputCharacter);
    }

    public static int getCalculationNumberByAlphabetUpperOrLowerCase(Character alphabet) {
        int calculationNumberByAlphabetUpperOrLowerCase = 0;
        if (Character.isUpperCase(alphabet)) {
            calculationNumberByAlphabetUpperOrLowerCase = getUpperCaseCalculationNumber();
        }
        if (Character.isLowerCase(alphabet)) {
            calculationNumberByAlphabetUpperOrLowerCase = getLowerCaseCalculationNumber();
        }
        return calculationNumberByAlphabetUpperOrLowerCase;
    }

    public static int getUpperCaseCalculationNumber() {
        return 'A' + 'Z';
    }

    public static int getLowerCaseCalculationNumber() {
        return 'a' + 'z';
    }

    public static void validateWord(String momWord) {
        if(!validateWordRange(momWord)) {
            throw new IllegalArgumentException("[ERROR] : 엄마 말씀은 1 이상 1,000이하의 문자열이어야합니다.");
        }
    }

    public static boolean validateWordRange(String momWord) {
        return (momWord.length() >= 1 && momWord.length() <= 1000);
    }
}