package onboarding;

import java.util.List;

public class Problem2 {
    private static StringBuffer cryptoBuffer = new StringBuffer();
    public static String solution(String cryptogram) {
        cryptoBuffer = new StringBuffer(cryptogram);

        String answer = "answer";

        while(checkOverlapString()) {
            int index = findOverlapIndex();

            deleteOverlapWord(index);
        }

        answer = cryptoBuffer.toString().trim();

        return answer;
    }
    private static boolean checkOverlapString() {
        boolean checkOverlap = false;

        for(int i = 0 ; i < cryptoBuffer.length()-1; i++) {
            if(cryptoBuffer.charAt(i) == cryptoBuffer.charAt(i+1)) {
                checkOverlap = true;
                break;
            }
        }

        return checkOverlap;
    }

    private static int findOverlapIndex() {
        int index = -1;

        for(int i = 0 ; i < cryptoBuffer.length()-1; i++) {
            if(cryptoBuffer.charAt(i) == cryptoBuffer.charAt(i+1)) {
                index = i;
                break;
            }
        }

        return index;
    }

    private static void deleteOverlapWord(int index) {
        cryptoBuffer.delete(index,index+2);
        return;
    }

}
