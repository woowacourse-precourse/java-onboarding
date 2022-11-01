package onboarding;
import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = cryptogram.toCharArray();

        // 스택에 넣기
        for (char c: chars) {
            insertStack(stack, c);
        }

        // 스택에서 빼기
        while(!stack.empty()){
            sb.append(stack.peek());
            stack.pop();
        }

        String answer = sb.reverse().toString();
        return answer;
    }

    private static void insertStack(Stack<Character> stack, char c){
        if (!stack.empty() && stack.peek() == c){
            stack.pop();
            return;
        }
        stack.push(c);
    }

}
