package onboarding;

import java.util.Stack;

/**
 * 예외처리에 대한 내용이 없어 예외사항 생략
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = decrypt(cryptogram);
        return answer;
    }

    private static String decrypt(String cryptogram) {

        Stack<Character> stack = new Stack<>();
        stack.push(cryptogram.charAt(0)); 
        StringBuilder sb = new StringBuilder();

        for (int cryptoLen=1; cryptoLen<cryptogram.length(); cryptoLen++) {
            if (stack.peek() == cryptogram.charAt(cryptoLen)) {  
                stack.pop();
                continue;
            }
            stack.push(cryptogram.charAt(cryptoLen));
        }

        while (!stack.empty()) {  
            sb.append(stack.pop());
        }
        return sb.reverse().toString(); 
    }
}
