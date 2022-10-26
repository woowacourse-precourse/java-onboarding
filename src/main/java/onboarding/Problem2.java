package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        char[] chars = cryptogram.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char ch : chars){
            stack.push(ch);
        }
        return answer;
    }
}
