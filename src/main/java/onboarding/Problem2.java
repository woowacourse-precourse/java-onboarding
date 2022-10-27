package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for(int i=0; i<cryptogram.length(); i++){
            left.push(cryptogram.charAt(i));
        }

        while(!left.isEmpty()) {
            if(right.isEmpty() || left.peek() != right.peek()) right.push(left.peek());
            else if(left.peek() == right.peek()){
                right.pop();
            }
            left.pop();
        }

        int rightsize = right.size();
        for(int i=0; i<rightsize; i++) {
            answer += right.pop();
        }
        return answer;
    }
}
