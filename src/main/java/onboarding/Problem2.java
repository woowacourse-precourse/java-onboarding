package onboarding;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Stack<Character> stack = new Stack<>();

        for (char c : cryptogram.toCharArray()) {
            if (!stack.isEmpty()) {
                if (stack.peek() == c){
                    stack.pop();
                }
            }
        }

        return answer;
    }
}
