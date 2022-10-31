/*
 * 클래스명: Problem2
 *
 * 시작 날짜: 2022-10-27
 */

package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        Decryption decryption = new Decryption();

        String answer = decryption.decryption(cryptogram);
        int cryptogramLength = cryptogram.length();

        for (int i=0; i<=(cryptogramLength/2); i++){
            if (cryptogram.equals(answer) || answer.equals("") || answer.length() == 1) {
                break;
            }
            cryptogram = answer;
            answer = decryption.decryption(cryptogram);
        }

        return answer;
    }
}

class Decryption{
    public String decryption(String word){
        String solvedWord = "";
        char overlapChar = ' ';
        int wordLength = word.length();


        for (int i=0; i<wordLength-1; i++){
            if (word.charAt(i) != word.charAt(i+1) && word.charAt(i) != overlapChar){
                solvedWord = solvedWord + word.charAt(i);
                overlapChar = ' ';
            } else if (word.charAt(i) == word.charAt(i+1)){
                overlapChar = word.charAt(i);
            }
        }
        // 마지막 문제까지 체크
        if (word.charAt(wordLength-1)!=word.charAt(wordLength-2) && word.charAt(wordLength-1)!=overlapChar){
            solvedWord = solvedWord + word.charAt(wordLength-1);
        }
        return solvedWord;
    }
}