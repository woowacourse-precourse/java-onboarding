package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        char[] strtmp = cryptogram.toCharArray();
        int flag = 0;

        if (cryptogram.length() < 1 || cryptogram.length() > 1000)
            return ("");
        for (int i = 0; i < cryptogram.length(); i++) {
            if (!(strtmp[i] >= 'a' && strtmp[i] <= 'z') && !(strtmp[i] >= 'A' && strtmp[i] <= 'Z'))
                return ("");
        }
        /*
            예외처리
            1. 문자열 길이
            2. 대문자, 소문자
        */
        for (int i = 0; i < cryptogram.length(); i++) {
            if (strtmp[i] != '0') {
                flag = 1;
                for (int j = i + 1; j < cryptogram.length(); j++) {
                    if (strtmp[j] == strtmp[i]) {
                        strtmp[j] = '0';
                        if (flag == 1)
                            flag = 0;
                        else if (flag == 0)
                            flag = 1;
                    }
                }
                if (flag == 1)
                    answer += strtmp[i];
            }
        /* 중복 알파벳 제외 */
        }
        return answer;
    }
}


