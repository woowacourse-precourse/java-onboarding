package onboarding.problem4;

public class Dictionary {

    /*
     * 문자열 (사전 반대 방향) 변환 함수
     */
    public static String convertWordIntoReverse(String word) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char currentCharacter = word.charAt(i);
            String currentString = String.valueOf(currentCharacter);

            if (Letter.isCapitalLetter(currentString)) {
                int findIndex = Letter.findTheOppositeIndexInCapitalLetters(currentCharacter);
                result.append(Letter.getCapitalLetterByIndex(findIndex));

            } else if (Letter.isSmallLetter(currentString)) {
                int findIndex = Letter.findTheOppositeIndexInSmallLetters(currentCharacter);
                result.append(Letter.getSmallLetterByIndex(findIndex));

            } else {
                result.append(currentString);
            }

        }

        return result.toString();
    }
}
