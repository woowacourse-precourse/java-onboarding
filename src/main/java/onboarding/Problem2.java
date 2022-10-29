package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        int start = 0;
        int l = 0;
        int r = 0;
        boolean isOverlap = false;

        while (l < cryptogram.length() - 1) {

            while (l < cryptogram.length() - 1 && cryptogram.charAt(l) == cryptogram.charAt(l + 1)) {
                if (isOverlap) {
                    r++;
                } else {
                    isOverlap = true;
                    start = l;
                    r = l + 1;
                }
                l++;
            }

            if (isOverlap) {
                isOverlap = false;
                cryptogram = cryptogram.substring(0, start) + cryptogram.substring(r + 1);
                start = 0;
                l = 0;
                r = 0;
                continue;
            }

            l++;
        }


        return cryptogram;
    }

}
