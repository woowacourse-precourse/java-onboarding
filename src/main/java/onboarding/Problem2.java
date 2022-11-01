package onboarding;

import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuffer sb = new StringBuffer(cryptogram);

        boolean flag = true;
        while (flag) {
            flag = false;
            for(int i=0; i<sb.length()-1; i++) {
                // i번째 i+1번째 중복인 경우 두 문자 제거
                if(sb.charAt(i) == sb.charAt(i+1)) {
                    sb.delete(i, i+2);
                    flag = true; // 중복 문자 제거 경우 반복
                }
            }
        }

        answer = String.valueOf(sb);
        return answer;
    }
}
