package onboarding;
import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char c: cryptogram.toCharArray()){
            if (!stack.empty() && stack.peek().equals(c)){
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        for (char c: stack){
            answer += c;
        }

        return answer;
    }
}