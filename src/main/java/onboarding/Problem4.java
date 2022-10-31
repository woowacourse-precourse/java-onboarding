package onboarding;

public class Problem4 {

    static final int UPPERCASE_DICTIONARY_SUM = 'A' + 'Z';
    static final int LOWERCASE_DICTIONARY_SUM = 'a' + 'z';
    static final int ALPHABET_LAST_INDEX = 25;
    static final int ALPHABET_START_INDEX = 0;


    public static String solution(String word) {
        return transferWordToOpposite(word);
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
