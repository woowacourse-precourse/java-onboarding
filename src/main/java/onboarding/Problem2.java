package onboarding;

import java.util.Stack;

public class Problem2 {
    /**
     * 기능 목록
     * 0. 기존에 짰던 코드가 zyelllleyz 테스트케이스를 추가했을 때 에러가 있어 새로 작성
     *    괄호 짝 맞추기 문제를 풀었던 기억을 살려서 stack을 사용
     * 1. cryptogram의 문자를 돌면서 stack에 push
     * 2. stack의 최상위와 현재 문자가 같다면 pop
     * 3. 겹친 문자는 따로 저장해두고 겹친 문자가 나오면 건너뛴다
     * 4. 스택의 요소를 꺼내서 역순으로 뒤집기
     */
    public static String solution(String cryptogram) {
        String answer = "answer";
        Stack<Character> stack = new Stack<>();
        char dup = ' ';

        // 1. cryptogram의 문자를 돌면서 stack에 push
        for (int i = 0; i < cryptogram.length(); i++) {
            char cur = cryptogram.charAt(i);
            if (!stack.isEmpty()) {
                // 3. 겹친 문자는 따로 저장해두고 겹친 문자가 나오면 건너뛴다
                if(cur == dup) {
                    continue;
                } else if (cur == stack.peek()) { // 2. stack의 최상위와 현재 문자가 같다면 pop
                    dup = cur;
                    stack.pop();
                    continue;
                }
            }
            stack.push(cur);
        }
        return answer;
    }
}