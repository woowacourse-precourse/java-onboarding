package onboarding.solution2;
import java.util.Stack;

public class RedundantChecker {
    private static int lenArr(char[] str) {
        int res = str.length;
        return res;
    }
    private static Stack<Character> makeStack(){
        Stack<Character> stack = new Stack<>();
        return stack;
    }

    private static char tmp(char c, char tmp){
        if (c == tmp){
            return tmp;
        }
        return c;
    }
    private static Stack<Character> pushOrPut(char c, Stack<Character> stack, char top){
        if (c == top){
            stack.pop();
            return stack;
        }
        stack.push(c);
        return stack;
    }
    public static Stack<Character> removeRedundancy(char[] str){
        int i = 0;
        int len = lenArr(str);
        Stack<Character> stack = makeStack();
        char top = stack.peek();
        char tmp = top;
        while (i < len){
            top = stack.peek();
            stack = pushOrPut(str[i], stack, top);
            tmp = tmp(str[i++], tmp);
        }
        return stack;
    }
}
