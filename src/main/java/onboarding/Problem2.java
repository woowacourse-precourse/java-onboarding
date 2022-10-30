package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while(hasConsecutiveChars(cryptogram)){

        }
        return cryptogram;
    }

    public static boolean hasConsecutiveChars(String cryptogram) {
        for(int i = 0; i < cryptogram.length() - 1; i++) {
            if(cryptogram.charAt(i) == cryptogram.charAt(i+1))
                return true;
        }
        return false;
    }
}
