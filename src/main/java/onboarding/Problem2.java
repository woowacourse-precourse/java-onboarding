package onboarding;

import java.util.ArrayList;
import java.util.List;

class Decryption {
    final int START=0;
    final int END=1;
    boolean isSameAlphabet(char previous, char next) {
        return previous == next;
    }
    boolean isRedundant(int startPosition, int endPosition) {
        return startPosition != endPosition;
    }
    void addRedundantIndex(List<Integer> redundantIndex, List<List<Integer>> redundantIndexes){

        if(isRedundant(redundantIndex.get(START), redundantIndex.get(END))){
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
        final int INITIALIZER=0;
        int cipherArrayLength = cryptogram.length()-2;
        List<List<Integer>> redundantIndex=new ArrayList<>();
        List<Integer> sequence;
        for(int i=INITIALIZER;i<=cipherArrayLength;i++){
            sequence=findRedundantAlphabet(cryptogram,i);
            addRedundantIndex(sequence, redundantIndex);
        }
        return redundantIndex;
    }
    String getRedundantAlphabet(String cryptogram, List<Integer> redundantIndex) {
        return cryptogram.substring(redundantIndex.get(START), redundantIndex.get(END) + 1);
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
        final int NO_REDUNDANT=0;
        return numberOfRedundant!=NO_REDUNDANT;
    }
}
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        Decryption operator = new Decryption();
        int redundantCount = Integer.MAX_VALUE;
        List<List<Integer>> redundantIndex;
        List<String> redundantString;
        String newCipher=cryptogram;
        while((operator.existsRedundantAlphabet(redundantCount))){
            redundantIndex=operator.redundantCheck(newCipher);
            redundantCount=redundantIndex.size();

            redundantString=operator.getRedundantSequence(newCipher,redundantIndex);
            newCipher=operator.getDecryption(newCipher, redundantString);
        }
        answer=newCipher;
        System.out.println(answer);
        return answer;
    }
}
