package onboarding;
import java.util.Stack;
public class Problem2 {
    public static String solution(String cryptogram) {
        char[] splitString = cryptogram.toCharArray();
        Stack<Character> noOverlapStack = removeOverlap(splitString);
        return toString(noOverlapStack);
    }
    /* Checking overlap for char[] -> stack */
    private static Stack<Character> removeOverlap(char[] charArray) {
        Stack<Character> stack = new Stack<>();
        for (char element : charArray) {
            if (stack.empty()) {
                stack.push(element);
                continue;
            }
            if (stack.peek() == element) {
                stack.pop();
            } else {
                stack.push(element);
            }
        }
        return stack;
    }
    /* stack -> string (without reverse) */
    private static String toString(Stack<Character> stack) {
        int size = stack.size();
        if (size == 0) {
            return "";
        }
        char[] tmp = new char[size];
        for (int i = size; i > 0; i--) {
            tmp[i-1] = stack.pop();
        }
        return String.valueOf(tmp);
    }
}
