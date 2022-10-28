package onboarding;

/**
 * 임의의 문자열 cryptogram 이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.
 */

/**
 * 제한 사항
 * cryptogram 은 길이가 1 이상 1000 이하인 문자열이다.
 * cryptogram 은 알파벳 소문자로만 이루어져 있다.
 */

/**
 * 진행 순서
 * "browoanoommnaon" ==> oomm 삭제
 * "browoannaon"  ==> nn 삭제
 * "browoaaon" ==> aa 삭제
 * "browoon" ==> oo 삭제
 * "brown" ==> return
 */

/**
 * Stack 활용
 * 1. Stack에 cryptogram 를 하나씩 넣는다
 * 2. Stack에 마지막 자료와 넣는 자료를 비교하여 같은면 pop 을 하고 넣으려고 하는 자료는 Stack 에 넣지 않는다.
 * 3. 이 과정을 반복 수행
 * 4. stack 에 있는 자료들을 문자열로 return
 */

import java.util.Stack;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = decrypt(cryptogram);
        return answer;
    }

    public static String decrypt(String cryptogram) {

        Stack<Character> stack = new Stack<>();
        stack.push(cryptogram.charAt(0)); // Stack 첫 번째에는 무조건 값을 넣음

        for (int i=1; i<cryptogram.length(); i++) {
            if (stack.peek() == cryptogram.charAt(i)) {  // 현재 Stack 의 마지막값과 넣으려고 하는 값을 비교해서 같으면 pop => continue
                stack.pop();
                continue;
            }
            stack.push(cryptogram.charAt(i)); // 스택에 cryptogram 를 하나씩 push
        }

    }
}
