package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
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
