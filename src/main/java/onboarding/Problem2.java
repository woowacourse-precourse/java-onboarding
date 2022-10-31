package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean isDuplicateExist = false;
        int si = 0, ei = 0;
        for(int i = 1; i < cryptogram.length(); i++) {
            if(cryptogram.charAt(si) == cryptogram.charAt(i)) {
                ei = i;
                isDuplicateExist = true;
            } else {
                if(isDuplicateExist) cryptogram = cryptogram.substring(0, si) + cryptogram.substring(ei+1);
                si = i;
                ei = i;
            }
        }
        if(isDuplicateExist) return solution(cryptogram);
        return cryptogram;
    }
}
