package onboarding;

public class Problem2 {
    public static String removeOverlap(String cryptogram) {
        String removedCrytogram = "";
        boolean isOverlap = false;

        if(cryptogram.length() == 1) {
            removedCrytogram = cryptogram;
        }

        for (int i = 0 ; i < cryptogram.length()-1 ; i++) {
            if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                isOverlap = true;
            }

            if(cryptogram.charAt(i) != cryptogram.charAt(i+1)) {
                if(!isOverlap) {
                    removedCrytogram = removedCrytogram + cryptogram.charAt(i);
                }

                if(i == cryptogram.length()-2) {
                    removedCrytogram = removedCrytogram + cryptogram.charAt(i+1);
                }

                isOverlap = false;
            }
        }

        return removedCrytogram;
    }

    public static boolean checkInput(String cryptogram) {
        if(cryptogram.length() < 1 || cryptogram.length() > 1000) {
            return false;
        }

        for(int i=0 ; i<cryptogram.length() ; i++) {
            char word = cryptogram.charAt(i);
            if (!(word >= 'a' && word <= 'z')) {
                return false;
            }
        }

        return true;
    }

    public static String solution(String cryptogram) {
        if(!checkInput(cryptogram)) {
            return "";
        }

        String answer = cryptogram;

        while(!removeOverlap(answer).equals(answer)) {
            answer = removeOverlap(answer);
        }

        return answer;
    }
}
