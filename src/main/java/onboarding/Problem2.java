package onboarding;
import java.util.Stack;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        Stack<Integer> stack = new Stack<Integer>();

        String ss = "";

        for (int i = 0; i < cryptogram.length(); i++) {
            if (!stack.empty()) {
                if (cryptogram.charAt(stack.peek()) != cryptogram.charAt(i)) {
                    stack.push(i);
                }
                else
                {
                    stack.pop();
                }
            }
            else {
                stack.push(i);
            }
        }


        return answer;
    }
}
