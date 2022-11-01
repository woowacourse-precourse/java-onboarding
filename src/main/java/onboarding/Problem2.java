package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = removeDuplication(cryptogram);
        return answer;
    }

    public static String removeDuplication(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        boolean dupCheck = false;
        stack.push(cryptogram.charAt(0));
        for(int i = 1; i < cryptogram.length(); i++) {
            if (stack.peek() == cryptogram.charAt(i)) {
                if (stack.size() == 1) {
                    stack.pop();
                }
                dupCheck = true;
            }else if(stack.peek() != cryptogram.charAt(i)) {
                if (dupCheck) {
                    dupCheck = false;
                    stack.pop();
                    i -= 1;
                    continue;
                }
                stack.push(cryptogram.charAt(i));
            }
        }
        String answer = "";
        for (int i = 0; i < stack.size(); i++) {
            answer += String.valueOf(stack.get(i));
        }
        return answer;
    }
}
