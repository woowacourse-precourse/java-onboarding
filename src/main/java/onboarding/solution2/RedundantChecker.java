package onboarding.solution2;
import java.util.Stack;

public class RedundantChecker {
    private static int lenArr(char[] str) {
        int arr = str.length;
        return arr;
    }

    private static char tmp(char c, char t){
        if (c == t){
            return t;
        }
        return c;
    }

    private static Stack<Character> ifNotEmptyPop(Stack<Character> stack){
        if (!stack.isEmpty()){
            stack.pop();
        }
        return stack;
    }
    private static char ifNotEmptyPeek(Stack<Character> stack){
        if (!stack.isEmpty()){
            return stack.peek();
        }
        return '\0';
    }
    private static Stack<Character> pushOrPop(char c, Stack<Character> stack, char top){
        if (c == top){
            ifNotEmptyPop(stack);
            return stack;
        }
        stack.push(c);
        return stack;
    }
    public static Stack<Character> removeRedundancy(char[] str){
        int i = 0;
        int len = lenArr(str);
        Stack<Character> stack = new Stack<>();
        if (i == 0){
            stack.push(str[i++]);
        }
        char top = stack.peek();
        char tmp = top;
        while (i < len){
            stack = pushOrPop(str[i], stack, top);
            tmp = tmp(str[i++], tmp);
            top = ifNotEmptyPeek(stack);
        }
        return stack;
    }
}
