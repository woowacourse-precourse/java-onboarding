package onboarding;

import java.util.Stack;

/**
 * 문제 분석
 * 1. 기능 요구사항속 예시를 볼때 문자열 속 중복문자를 더이상 중복문자를 갖지 않는 상태가 될때 까지 제거해야한다.
 * 2. 정규식으로 해결할수 있으나 O(n) 시간안에 해결 가능하도록 Stack 을 사용하여 해결하도록한다.
 *      Stack 으로 구현시 아래와 같은 로직을 따르도록 한다.
 *      현재 보고있는 문자열속 문자를 ch , 중복되고있는 문자를 tmp 라고할때
 *      1. tmp 변수가 null 이면 두가지 경우로 나뉜다.
 *          1. Stack 이 비어있거나 ch가 중복 문자가 아닌경우
 *                  -> Stack 에 ch를 추가한다.
 *          2. ch가 중복 문자인경우
 *                  -> tmp 변수를 중복되는 문자로 갱신시킨다.
 *      2. tmp 에 문자가 들어있는 경우 2가지 경우로 나뉜다.
 *          1. ch와 tmp 가 같은경우
 *                  -> ch는 중복 문자이므로 아무것도 하지않고 다음 문자를 확인한다.
 *          2. ch 와 tmp 가 다른경우
 *                  -> ch 는 중복 문자가 아니므로 tmp 를 null로 갱신 시킨후 ch 에 대해서 다시한번 로직을 수행 시키도록 한다.
 * */
public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> st = new Stack<>();
        Character tmp = null;
        for (int i = cryptogram.length() - 1; i >= 0; i--) {
            char ch = cryptogram.charAt(i);
            if (tmp == null) {
                if (st.isEmpty() || st.peek() != ch) {
                    st.add(ch);
                } else if (st.peek() == ch) {
                    tmp = st.pop();
                }
            } else {
                if (tmp != ch) {
                    tmp = null;
                    i++;
                }
            }
        }
        while (!st.isEmpty()) {
            answer.append(st.pop());
        }
        return new String(answer);
    }
}
