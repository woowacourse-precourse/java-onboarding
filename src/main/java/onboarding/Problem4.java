package onboarding;

public class Problem4 {

    static final int UPPERCASE_DICTIONARY_SUM = 'A' + 'Z';
    static final int LOWERCASE_DICTIONARY_SUM = 'a' + 'z';
    static final int ALPHABET_LAST_INDEX = 25;
    static final int ALPHABET_START_INDEX = 0;
    static final int INPUT_MINIMUM_LENGTH = 1;
    static final int INPUT_MAXIMUM_LENGTH = 1000;
    static final String INPUT_TOO_SHORT_EXCEPTION = "입력한 문자열이 존재하지 않습니다. ";
    static final String INPUT_TOO_LONG_EXCEPTION = "입력한 문자열이 1000자를 넘습니다. ";


    public static String solution(String word) {
        checkInput(word);
        return transferWordToOpposite(word);
    }

    private static void checkInput(String word){
        if(word.length() < INPUT_MINIMUM_LENGTH) inputTooShortException();
        if(word.length() > INPUT_MAXIMUM_LENGTH) inputTooLongException();
    }

    private static void inputTooShortException(){
        throw new IllegalArgumentException(INPUT_TOO_SHORT_EXCEPTION);
    }

    private static void inputTooLongException(){
        throw new IllegalArgumentException(INPUT_TOO_LONG_EXCEPTION);
    }

    private static String transferWordToOpposite(String word){
        StringBuilder wordBuilder = new StringBuilder();
        for(int i=0; i<word.length(); i++){
            wordBuilder.append(addNext(word.charAt(i)));
        }
        return wordBuilder.toString();
    }

    private static char addNext(char nextCharacter){
        if(isUppercase(nextCharacter)) return flipUpperCase(nextCharacter);
        if(isLowercase(nextCharacter)) return flipLowerCase(nextCharacter);
        return nextCharacter;
    }

    private static boolean isUppercase(char nextCharacter){
        if(nextCharacter - 'A' >= ALPHABET_START_INDEX && nextCharacter - 'A' <= ALPHABET_LAST_INDEX)
            return true;
        return false;
    }

    private static boolean isLowercase(char nextCharacter){
        if(nextCharacter - 'a' >= ALPHABET_START_INDEX && nextCharacter - 'a' <= ALPHABET_LAST_INDEX) return true;
        return false;
    }

    private static char flipUpperCase(char alphabet){
        return (char) (UPPERCASE_DICTIONARY_SUM - alphabet);
    }

    private static char flipLowerCase(char alphabet){
        return (char) (LOWERCASE_DICTIONARY_SUM - alphabet);
    }
}
