package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        // isDuplicated: 중복 발생 여부를 체크하는 변수
        boolean isDuplicated = false;
        // stk: 새로 만들 문자열을 저장하는 스택
        Deque<Character> stk = new ArrayDeque<>();

        int i = 0;
        while(i < cryptogram.length()) {
            // 스택이 비어있거나, 스택의 마지막 문자와 입력 문자가 다르면서 중복이 발생하지 않았을 때
            // 입력 문자를 그대로 스택에 넣고, 인덱스 증가
            if(stk.isEmpty() || stk.peek() != cryptogram.charAt(i) && !isDuplicated) {
                stk.push(cryptogram.charAt(i));
                i++;
            // 스택의 마지막 문자와 입력 문자가 같으면 중복이 발생했음을 체크하고 인덱스 증가
            } else if(stk.peek() == cryptogram.charAt(i)) {
                isDuplicated = true;
                i++;
            // 스택의 마지막 문자와 입력 문자가 다르면서 중복이 발생했을 때는 스택에서 문자를 빼고 중복 발생 체크 해제
            } else {
                stk.pop();
                isDuplicated = false;
            }
        }
        // 중복 발생 여부에 따라 마지막 문자 제거
        if(isDuplicated)
            stk.pop();

        // 스택에 있는 문자열을 뒤집에서 출력
        StringBuilder sb = new StringBuilder();
        for(char c: stk)
            sb.append(c);
        answer = sb.reverse().toString();

        return answer;
    }
}
