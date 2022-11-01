package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {

        // 해독 전 문자열 크기
        int beforeSize = 0;

        String result = cryptogram;

        while (beforeSize != result.length()) {

            String tmp = "";
            beforeSize = result.length();

            // 문자열 길이가 0 또는 1인 경우
            if (result.length() <= 1) {
                return result;
            }

            // 첫번째 문자인 경우
            if (result.charAt(0) != result.charAt(1)) {
                tmp += result.charAt(0);
            }

            for (int i = 1; i < result.length() - 1; i++) {
                if (result.charAt(i) != result.charAt(i - 1) && result.charAt(i) != result.charAt(i + 1)) {
                    tmp += result.charAt(i);
                }
            }

            // 마지막 문자인 경우
            if (result.charAt(result.length() - 1) != result.charAt(result.length() - 2)) {
                tmp += result.charAt(result.length() - 1);
            }
            result = tmp;
        }

        return result;
    }
}
