package onboarding.problem4;

public class LetterReverser {

    private static final char FIRST_UPPER_CASE = 'A';
    private static final char LAST_UPPER_CASE = 'Z';
    private static final char FIRST_LOWER_CASE = 'a';
    private static final char LAST_LOWER_CASE = 'z';

    public static char reverseOnlyEnglish(char letter){
        if (isUpperCaseEnglishLetter(letter)){
            return changeUpperCaseLetter(letter);
        }
        if (isLowerCaseEnglishLetter(letter)){
            return changeLowerCaseLetter(letter);
        }
        return letter;
    }

    private static boolean isUpperCaseEnglishLetter(char letter){
        return FIRST_UPPER_CASE <= letter && letter <= LAST_UPPER_CASE;
    }

    private static boolean isLowerCaseEnglishLetter(char letter){
        return FIRST_LOWER_CASE <= letter && letter <= LAST_LOWER_CASE;
    }

    private static char changeUpperCaseLetter(char letter){
        return (char) (FIRST_UPPER_CASE + LAST_UPPER_CASE - letter);
    }

    private static char changeLowerCaseLetter(char letter){
        return (char) (FIRST_LOWER_CASE + LAST_LOWER_CASE - letter);
    }
}
