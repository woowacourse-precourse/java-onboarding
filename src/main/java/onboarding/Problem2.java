package onboarding;

import java.util.Stack;


public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        // 연속 중복 문자를 삭제하기

        // 스택을 이용해서 가장 위의 값과 삽입하려는 값이 같으면 삭제
        StringBuffer sb = new StringBuffer();

        // 0은 바로 삽입
        sb.append(cryptogram.charAt(0));

        for (int i = 1; i < cryptogram.length(); i++) {
            // 가장 뒤의 값 추출
            char lastAlphabet = sb.charAt(sb.length() - 1);

            // 만약 가장 뒤의 값과 삽입하려는 값이 같으면 -> 삭제
            if (cryptogram.charAt(i) == lastAlphabet) {
                sb.deleteCharAt(sb.length() - 1);
            }
            // 아니라면 삽입
            else {
                sb.append(cryptogram.charAt(i));
            }
        }

        answer = sb.toString();

        return answer;
    }
}
