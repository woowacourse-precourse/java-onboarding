package onboarding;


public class Problem4 {
    static final String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String smallLetters = "abcdefghijklmnopqrstuvwxyz";

    private static boolean isCapitalLetter(String character){

        return capitalLetters.contains(character);
    }

    private static boolean isSmallLetter(String character){

        return smallLetters.contains(character);
    }
    private static int findTheOppositeIndex(String referenceLetters, Character currentCharacter) {

        return referenceLetters.length() - 1 - referenceLetters.indexOf(currentCharacter);
    }

}
