package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        String[] removeSenString = new String[2];
        removeSenString[0] = cryptogram;
        removeSenString[1] = cryptogram;
        for (int i = 0;; i = (i + 1) % 2) {
            removeSenString[i] = removeDuplicates(removeSenString[(i + 1) % 2]);
            if (removeSenString[i].equals(removeSenString[(i + 1) % 2])) {
                answer = removeSenString[i];
                return answer;
            }
        }
    }

    public static String removeDuplicates(String cryptogram) {

        for (int i = 0; i < cryptogram.length() - 1; i++) {
            int countFreq;
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                for (countFreq = 1; cryptogram.charAt(i) == cryptogram.charAt(i + countFreq); countFreq++ ) {
                    if (i + countFreq + 1 >= cryptogram.length()) {
                        cryptogram = cryptogram.substring(0,i) + cryptogram.substring(i + countFreq + 1, cryptogram.length());
                        return cryptogram;
                    }
                }
                cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + countFreq, cryptogram.length());
            }
        }
        return cryptogram;
    }
}
