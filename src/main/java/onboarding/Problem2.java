package onboarding;
import java.util.Stack;
public class Problem2 {
    public static String solution(String cryptogram) {
        char [] splitString = cryptogram.toCharArray();
        Stack<Character> noDuplicatesStack = overlapCheckStack(splitString);
        return stackToString(noDuplicatesStack);
    }
    private static Stack<Character> overlapCheckStack(char [] charArray){
        Stack<Character> stack = new Stack<>();
        for(char element :charArray){
            if (stack.empty()) {
                stack.push(element);
                continue;
            }
            if (stack.peek()==element){
                stack.pop();
            }else{
                stack.push(element);
            }
        }
        return stack;
    }
    private static String stackToString(Stack<Character> charStack){
        int size = charStack.size();
        if (size== 0){ return "";}
        char [] tmp = new char[size];
        for(int i = size; i >0; i--){
            tmp[i-1] = charStack.pop();
        }
        return String.valueOf(tmp);
    }
}
