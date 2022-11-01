package onboarding;

import java.util.HashMap;

public class Problem2 {

    public static String solution(String cryptogram) {

        while(true) {
            String code = checkDuplicated(cryptogram);
            if (cryptogram.equals(code)) {
                break;
            }
            cryptogram = code;
        }
        return cryptogram;
    }

    private static String checkDuplicated(String code) {
        for (int i =0; i < code.length() - 1; i++) {
            if (code.charAt(i) == code.charAt(i+1)) {
                code = removeDuplicated(code);
            }
        }
        return code;
    }

    private static String removeDuplicated(String cryptogram) {
        return cryptogram.replaceAll("(([a-z])\\2{1,})", "");
    }
}
