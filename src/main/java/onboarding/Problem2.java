package onboarding;

import java.util.Deque;
import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        // 0. 문제 해결에 필요한 자료형, 변수의 선언
        Deque<Character> deque = new LinkedList<>(); // 마지막에 출력의 편의성을 위해 Deque를 사용
        StringBuilder sb = new StringBuilder();
        boolean seq = false; // 연속되는 패턴이 시작되었는 가?

        // 1. 임의의 문자열 cryptogram을 문자의 배열로 변환
        char[] letters = cryptogram.toCharArray();

        // 2. Stack을 활용하여 중복된 문자를 제거함
        for(int i=0 ; i<letters.length ; i++) {
            if(deque.isEmpty()) deque.add(letters[i]); // stack이 빈 경우 - 문자를 추가
            else if(deque.peekLast() != letters[i]) {  // stack의 top가 다른 문자가 나타난 경우
                if(!seq) // 연속된 문자가 나타나지 않은 경우 - 문자를 stack에 추가
                    deque.add(letters[i]);
                else { // 연속된 문자가 나타난 경우 - seq를 초기화, stack에서 하나의 원소를 pop, 재탐색을 위해 i값 1 감소
                    seq = false;
                    deque.pollLast();
                    i--;
                }
            }
            else if(deque.peekLast() == letters[i]) // stack의 top과 같은 문자가 나타난 경우 - seq를 true로 변경
                seq = true;
        }
        if(seq) deque.pollLast(); // 연속된 문자가 나타난 경우 - stack에서 하나의 원소를 pop함

        // 3. 처리가 완료된 결과(Stack에 남아있는 문자)를 출력함
        for(char c : deque)
            sb.append(c);
        answer = sb.toString();

        return answer;
    }
}
