package onboarding;

import java.util.ArrayList;
import java.util.List;

class StringOperation {
    boolean isSameAlphabet(char previous, char next) {
        return previous == next;
    }
    boolean isRedundant(int startPosition, int endPosition) {
        return startPosition != endPosition;
    }
    void addRedundantIndex(List<Integer> redundantIndex, List<List<Integer>> redundantIndexes){

        if(isRedundant(redundantIndex.get(0), redundantIndex.get(1))){
            redundantIndexes.add(redundantIndex);
        }
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
    List<List<Integer>> redundantCheck(String cryptogram){
        int cipherArrayLength = cryptogram.length()-2;
        List<List<Integer>> redundantIndex=new ArrayList<>();
        List<Integer> sequence;
        for(int i=0;i<=cipherArrayLength;i++){
            sequence=findRedundantAlphabet(cryptogram,i);
            addRedundantIndex(sequence, redundantIndex);
        }
        return redundantIndex;
    }
    String getRedundantAlphabet(String cryptogram, List<Integer> redundantIndex) {
        return cryptogram.substring(redundantIndex.get(0), redundantIndex.get(1) + 1);
    }
    List<String> getRedundantSequence(String cryptogram, List<List<Integer>> redundantIndex){
        List<String> redundantAlphabet = new ArrayList<>();
        for(List<Integer> index: redundantIndex){
            redundantAlphabet.add(getRedundantAlphabet(cryptogram, index));
        }
        return redundantAlphabet;
    }
    String getDecryption(String cipher, List<String> redundantCharacter){
        String newCipher=cipher;
        for(String character: redundantCharacter){
            newCipher=newCipher.replace(character, "");
        }
        return newCipher;
    }
    boolean existsRedundantAlphabet(int numberOfRedundant){
        return numberOfRedundant!=0;
    }
}
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
