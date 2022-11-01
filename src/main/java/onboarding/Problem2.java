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
     *
     * 0'. baooaan 테스트 케이스를 추가했더니 에러가 있어서 추가 수정
     * 2 -> 2'.  stack의 최상위와 현재 문자가 같다면 cur를 dup에 저장
     * 3 -> 3'. peek과 cur가 다른데 cur가 dup과도 다르다면 일반적으로 서로 다른 문자가 나오거나
     *          연속된 부분이 끝났다는 것을 의미하는데 peek과 dup을 비교해서 같다면 연속된 부분이
     *          끝난 것을 의미하므로 pop을 여기서 해준다.
     * 5. cryptogram의 마지막에 2개 문자가 연속된다면
     *    dup을 지정하기 전이라서 잡아낼 수 없으므로 따로 pop을 해준다.
     * 6. 동일한 과정을 cryptogram이 변하지 않을 때까지 반복
     */
    public static String solution(String cryptogram) {
        String answer = "";
        // 6. 동일한 과정을 cryptogram이 변하지 않을 때까지 반복
        while(true) {
            int len = cryptogram.length();
            cryptogram = removeDuplicateChars(cryptogram);
            if(cryptogram.length() == len) {
                answer = cryptogram;
                break;
            }
        }
        return answer;
    }

    private static String removeDuplicateChars(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        char dup = ' ';

        // 1. cryptogram의 문자를 돌면서 stack에 push
        for (int i = 0; i < cryptogram.length(); i++) {
            char cur = cryptogram.charAt(i);
            if (!stack.isEmpty()) {
                if (cur == stack.peek()) { // 2'. stack의 최상위와 현재 문자가 같다면 cur를 dup에 저장
                    dup = cur;
                    /*
                     5. cryptogram의 마지막에 2개 문자가 연속된다면
                        dup을 지정하기 전이라서 잡아낼 수 없으므로 따로 pop을 해준다.
                     */
                    if(i == cryptogram.length() - 1) {
                        stack.pop();
                    }
                    continue;
                } else {
                    /*
                     3'. peek과 cur가 다른데 cur가 dup과도 다르다면 일반적으로 서로 다른 문자가 나오거나
                        연속된 부분이 끝났다는 것을 의미하는데 peek과 dup을 비교해서 같다면 연속된 부분이
                        끝난 것을 의미하므로 pop을 여기서 해준다.
                     */
                    if(cur != dup) {
                        if(stack.peek() == dup) {
                            stack.pop();
                        }
                    }
                }
            }
            stack.push(cur);
        }
        // 4. 스택의 요소를 꺼내서 역순으로 뒤집기
        while(!stack.isEmpty()) {
            temp.append(Character.toString(stack.pop()));
        }
        temp.reverse();
        return temp.toString();
    }

}