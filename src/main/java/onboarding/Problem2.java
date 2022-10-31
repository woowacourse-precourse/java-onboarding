package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        answer = deleteOverlap(cryptogram);
        return answer.toString();
    }

    public static StringBuilder deleteOverlap(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        left = makeLeftStack(cryptogram);

        while(!left.isEmpty()) {
            if(right.isEmpty() || left.peek() != right.peek()) right.push(left.peek());
            else if(left.peek() == right.peek()){
                right.pop();
            }
            left.pop();
        }

        answer = appendAnswer(right);

        return answer;
    }

    public static Stack<Character> makeLeftStack(String cryptogram) {
        Stack<Character> left = new Stack<>();
        for(int i=0; i<cryptogram.length(); i++){
            left.push(cryptogram.charAt(i));
        }
        return left;
    }
    public static StringBuilder appendAnswer(Stack<Character> right) {
        StringBuilder answer = new StringBuilder();
        int rightsize = right.size();
        for(int i=0; i<rightsize; i++) {
            answer.append(right.pop());
        }
        return answer;
    }
}
