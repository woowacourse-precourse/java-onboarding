package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        while(!answer.equals(cryptogram)){
            answer = cryptogram;
            cryptogram = removeDuplicateCharacters(cryptogram);
        }
        return answer;
    }

    public static String removeDuplicateCharacters(String word) {
        if(word.isEmpty()) return word;
        char[] wordArray = word.toCharArray();
        String duplicateRemovedWord = "";
        char duplicatedCharacter = '\0';
        int currentCharacter;
        for (currentCharacter = 0; currentCharacter < word.length() - 1; currentCharacter++) {
            boolean isSameAsNextCharacter = wordArray[currentCharacter] == wordArray[currentCharacter+1];
            boolean isSameAsDuplicatedCharacter = wordArray[currentCharacter] == duplicatedCharacter;
            if(isSameAsNextCharacter || isSameAsDuplicatedCharacter){
                duplicatedCharacter = wordArray[currentCharacter];
            }
            else {
                duplicateRemovedWord += wordArray[currentCharacter];
                duplicatedCharacter = '\0';
            }
        }
        char lastCharacter = wordArray[currentCharacter];
        if(lastCharacter != duplicatedCharacter) duplicateRemovedWord += wordArray[currentCharacter];
        return duplicateRemovedWord;
    }
}