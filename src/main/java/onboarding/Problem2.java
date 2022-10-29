package onboarding;

import java.lang.reflect.ParameterizedType;
import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        //스택을 생성한다.
        Stack<String> stack = new Stack<>();

        //cryptogram을 순회한다.
        for (String s: cryptogram.split("")) {

            //스택이 비어있으면 문자를 추가해준다.
            if (stack.empty()) {
                stack.add(s);
                continue;
            }

            //스택의 중복의경우 제외시켜준다.
            if (stack.peek().equals(s)) {
                stack.pop();
            }
            //중복이 아니라면 스택에 문자를 추가해준다.
            else {
                stack.add(s);
            }
        }

        //stack을 string으로 변환한다.
        for (String s: stack) {
            answer += s;
        }

        return answer;
    }
}
