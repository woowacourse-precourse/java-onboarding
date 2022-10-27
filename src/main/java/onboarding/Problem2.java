package onboarding;

import java.util.Stack;

/**
 * stack을 이용한 중복 문자열 제거
 * 1. 한글자씩 stack에 집어넣기
 *  1-1. stack의 top의 글자와 같으면 pop 하고 skip
 * 2. pop 하면서 글자를 붙인다 -> java는 인덱싱 가능하므로 순서대로 출력
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        Stack<Character> tower = new Stack<>();
        tower.push(cryptogram.charAt(0));

        for(int i=1; i<cryptogram.length(); i++) {
            char now = cryptogram.charAt(i);
            if (tower.peek() == now)
                tower.pop();
            else
                tower.push(now);
        }

        for(char c : tower) {
            answer += c;
        }

        return answer;
    }
}
