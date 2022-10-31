package onboarding;

import java.util.Stack;

/**
 * 문제 분석
 * 1. 기능 요구사항속 예시를 볼때 문자열 속 중복문자를 더이상 중복문자를 갖지 않는 상태가 될때 까지 제거해야한다.
 * 2. StringBuilder 을 사용하여 해결하도록한다.
 * 아래와 같은 로직을 따르도록 한다.
 * 현재 보고있는 문자열속 문자를 ch , 이전 문자를 pre 라고할때
 * 1. 초기 문자열을 StringBuilder 로 만든다.
 * 2. 문자열을 순회하며 pre 와 ch 가 같다면 StringBuilder 에서 해당 문자를 제거한다.
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder(cryptogram);
        boolean check = true;
        while (check) {
            check = false;
            char pre = ' ';
            int preIndex = -1;
            for (int i = 0; i < answer.length(); i++) {
                char ch = answer.charAt(i);
                if (pre != ch) {
                    if (preIndex < i - 1) {
                        check = true;
                        answer.delete(preIndex, i);
                        i = preIndex;
                    }
                    pre = ch;
                    preIndex = i;
                }
            }
            if (preIndex < answer.length() - 1) {
                answer.delete(preIndex, answer.length());
                check = true;
            }
        }
        return new String(answer);
    }
}
