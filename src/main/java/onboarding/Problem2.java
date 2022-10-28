package onboarding;

public class Problem2 {

    private static String findRepeatedChar(String cryptogram) {
        boolean flag = false;
        int lidx = 0;
        int ridx = 0;
        for (int i=1; i<=cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i-1)) {
                char repeatedChar = cryptogram.charAt(i);
                lidx = i-1;
                flag = true;
            if ((flag) & (cryptogram.charAt(i) != cryptogram.charAt(i-1))) {
                ridx = i;
                break;
                }
            }
        }
        if (flag) {
            cryptogram = cryptogram.substring(lidx, ridx);
        }
        return cryptogram;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
