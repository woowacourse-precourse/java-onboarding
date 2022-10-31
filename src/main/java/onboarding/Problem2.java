package onboarding;

public class Problem2 {
    public static String removeOverlap(String cryptogram) {
        String removedCrytogram = "";
        boolean isDuplicate = false;

        if(cryptogram.length() == 1) {
            removedCrytogram = cryptogram;
        }

        for (int i = 0 ; i < cryptogram.length()-1 ; i++) {
            if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                isDuplicate = true;
            }

            if(cryptogram.charAt(i) != cryptogram.charAt(i+1)) {
                if(!isDuplicate) {
                    removedCrytogram = removedCrytogram + cryptogram.charAt(i);
                }

                if(i == cryptogram.length()-2) {
                    removedCrytogram = removedCrytogram + cryptogram.charAt(i+1);
                }

                isDuplicate = false;
            }
        }

        return removedCrytogram;
    }

    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while(!removeOverlap(answer).equals(answer)) {
            answer = removeOverlap(answer);
        }

        return answer;
    }
}