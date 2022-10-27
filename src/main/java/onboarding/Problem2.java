package onboarding;
import java.util.Stack;
public class Problem2 {
    public static String solution(String cryptogram) {
        char [] splitString = cryptogram.toCharArray();
        Stack<Character> noDuplicatesStack = overlapCheckStack(splitString);
        String answer = "answer";
        return answer;
    }
    private static Stack<Character> overlapCheckStack(char [] charArray){
        Stack<Character> stack = new Stack<>();
        for(char element :charArray){
            char lastElement = stack.peek();
            if (lastElement==element){
                stack.pop();
            }else{
                stack.push(element);
            }
        }
        return stack;
    }
}
