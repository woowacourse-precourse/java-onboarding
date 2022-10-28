package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static String convertWord(String word) {
        String convertWord = "";
        for(int wordIndex = 0; wordIndex < word.length(); wordIndex++) {
            char charAtWord = word.charAt(wordIndex);
            if(Character.isAlphabetic(charAtWord)) {
                convertWord += convertAlphabet(charAtWord);
            }
            if(!Character.isAlphabetic(charAtWord)) {
                convertWord += charAtWord;
            }
        }
        return convertWord;
    }

    public static Character convertAlphabet(Character inputCharacter) {
        int calculationNum = getCalculationNumberByAlphabetUpperOrLowerCase(inputCharacter);
        return (char)(calculationNum - inputCharacter);
    }

    public static int getCalculationNumberByAlphabetUpperOrLowerCase(Character alphabet) {
        int calculationNumberByAlphabetUpperOrLowerCase = 0;
        if(Character.isUpperCase(alphabet)) {
            calculationNumberByAlphabetUpperOrLowerCase = getUpperCaseCalculationNumber();
        }
        if(Character.isLowerCase(alphabet)) {
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
}
