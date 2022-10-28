package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<String> res = new Stack<String>();
        String prev = "";

        for(String str : cryptogram.split("")) {
            pushOrSkip(str, prev, res);
            prev = str;
        }

        while(!res.isEmpty()) {
            answer = res.pop() + answer;
        }
        return answer;
    }

    public static void pushOrSkip(String cur, String prev, Stack<String> res) {
        // flag가 true면 stack에 push
        boolean flag = false;

        // 이전 문자와 현재문자가 같지 않다면 push할 가능성
        if(!cur.equals(prev)) {
            flag = true;
        }

        // 스택의 가장 위의 원소와 같다면 스택의 peek을 pop하고 새로운 원소를 push하지 않음
        if(!res.isEmpty()) {
            if(res.peek().equals(cur)) {
                res.pop();
                flag = false;
            }
        }

        if(flag) {
            res.push(cur);
        }
    }

}
