package onboarding;

import java.util.Stack;

public class Problem2 {
    /*
    - 문제 요구사항 정리 및 해결방법
    1. 입력된 문자열에서 순서대로 중복되는 문자 제거한 후, 결과 리턴
        - 스택의 LIFO구조를 활용하기 위해 Stack선언 및 세팅
        - 입력된 문자열을 하나씩 조회할 때 경우
            1. 조회된 값과 스택의 top이 같을 경우, 중복이 발생하하여 스택의 top를 pop
            2. 조회된 값과 스택의 top이 다를 경우, 중복이 발생하지 않아 통과
        - 선언한 Stack을 제출 형식에 맞게 타입 변경
     */
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<String> visited = new Stack<>();  // 중복 문자가 체크된 stack 선언
        visited.push(cryptogram.substring(0, 1));    // 스택 초기값 세팅

        for (String s : cryptogram.substring(1).split("")) {
            if (visited.peek().equals(s)) { // 중복문자 발생!!
                visited.pop();
            } else {    // 중복문자 발생 X
                visited.push(s);
            }
        }

        answer = String.join("", visited);

        return answer;
    }
}
