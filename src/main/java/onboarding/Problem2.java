package onboarding;

import java.util.HashSet;
import java.util.Stack;

public class Problem2 {
    /*
     *  Stack을 이용해서 해결.
     *      1. 스택 최상단의 숫자와 같다면 pop + prev값을 해당 숫자로 설정
     *      2. prev값과 같다면 연속되는 숫자 이므로 무시함
     *      3. 그외의 경우 stk에 푸쉬함.
     *  결국 모든 연달아 2개이상이 나오는 글자는 사라지게됨.
     *  stk에서 pop 하면서 result의 가장 앞에 붙여줌.(stack에서 넣은 반대 순서로 나오므로)
     */

    public static String solution(String cryptogram) {
        Stack<String> stk = new Stack<>();
        String prev = "";
        for(int i = 0; i<cryptogram.length(); i++){
            String current = cryptogram.substring(i, i + 1);
            if(stk.empty()) {
                stk.add(current);
            }
            else if (stk.peek().equals(current)) {
                stk.pop();
                prev = current;
            }
            else if (current.equals(prev)) {
                continue;
            }
            else {
                stk.add(current);
                prev = current;
            }
        }
        String answer = "";
        while(!stk.empty())
            answer = stk.pop() + answer;
        return answer;
    }
}
