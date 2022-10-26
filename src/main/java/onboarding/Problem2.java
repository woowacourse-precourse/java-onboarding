package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return "";
    }


    private static int isOverlap(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return i;
            }
        }
        return -1;
    }

}
