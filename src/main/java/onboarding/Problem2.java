package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean flag = false;
        int startIdx = 0;
        int endIdx = 0;
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                if (flag == false) {
                    startIdx = i;
                }
                flag = true;
            } else {
                if (flag == true) {
                    endIdx = i;
                    break;
                }
            }
        }

        if (flag == false) {
            return cryptogram;
        }

        return solution(cryptogram.replaceAll(cryptogram.substring(startIdx, endIdx + 1), ""));
    }
}
