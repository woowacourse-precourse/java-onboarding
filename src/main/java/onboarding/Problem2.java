package onboarding;
import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char c: cryptogram.toCharArray()){
            if (isDuplicated(stack, c)) continue;
            stack.push(c);
        }


        for (char c: stack){
            answer += c;
        }

        return answer;
    }

    private static boolean isDuplicated(Stack<Character> stack, char c){
        if (stack.isEmpty()) return false;
        if (stack.peek().equals(c) || stack.peek().equals(Character.toUpperCase(c))) {
            stack.pop();
            stack.push(Character.toUpperCase(c));
            return true;
        }
        if (Character.isUpperCase(stack.peek())){
            stack.pop();
            return isDuplicated(stack, c);
        }
        return false;
    }
}