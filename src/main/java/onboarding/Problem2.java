package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<String> stack = new Stack<>();
        String[] arr = cryptogram.split("");

        //중복 문자 제거 기능
        for (int i = 0; i < arr.length; i++) {
            if (stack.empty()) {
                stack.push(arr[i]);
            } else if (stack.peek().equals(arr[i])) {
                stack.pop();
            } else {
                stack.push(arr[i]);
            }
        }

        //결과값 출력 기능
        String answer = "answer";
        return answer;
    }
}
