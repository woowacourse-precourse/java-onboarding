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
    private static char getCharacterByIndex(String referenceLetters, int index) {

        return referenceLetters.charAt(index);
    }

    private static String convertWordsIntoReverse(String word) {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < word.length(); i++) {
            char currentCharacter = word.charAt(i);
            String currentString = String.valueOf(currentCharacter);


            if(isCapitalLetter(currentString)) {
                int findIndex = findTheOppositeIndex(capitalLetters, currentCharacter);
                result.append(getCharacterByIndex(capitalLetters, findIndex));

            } else if(isSmallLetter(currentString)){

                int findIndex = findTheOppositeIndex(smallLetters, currentCharacter);
                result.append(getCharacterByIndex(smallLetters, findIndex));

            } else {
                result.append(currentString);
            }

        }

        return result.toString();
    }

    public static String solution(String word) {

        return convertWordsIntoReverse(word);
    }
}
