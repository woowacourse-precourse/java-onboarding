package onboarding;

import java.util.List;

class StringOperation {
    boolean isSameAlphabet(char previous, char next) {
        return previous == next;
    }
    List<Integer> findRedundantAlphabet(String cryptogram, int startIndex) {

        int movingIndex = startIndex;
        List<Integer> redundantCharacterIndex;
        while ((movingIndex+1<cryptogram.length())&&isSameAlphabet(cryptogram.charAt(movingIndex), cryptogram.charAt(movingIndex + 1))) {
            movingIndex++;
        }
        redundantCharacterIndex = List.of(startIndex, movingIndex);
        return redundantCharacterIndex;
    }
    String removeRedundantAlphabet(String cipher, List<String> redundantCharacter){
        String newCipher=cipher;
        for(String character: redundantCharacter){
            newCipher=newCipher.replace(character, "");
        }
        return newCipher;
    }
}
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
