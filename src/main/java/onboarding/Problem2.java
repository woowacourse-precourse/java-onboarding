package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        int i=0;
        while (i != cryptogram.length()-1) {
            if (cryptogram.length() == 0) break;
            for (i = 0; i < cryptogram.length()-1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i+1)){
                    cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i+2);
                    i = 0;
                    break;
                }
            }
        }

        return cryptogram;
    }

}
