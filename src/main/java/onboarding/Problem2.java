package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        return processCryptogaming(cryptogram);
    }

    static String processCryptogaming(String cryptogram) {
        while (true) {
            String newCryptogram = getCryptogram(cryptogram);

            if (newCryptogram.equals(cryptogram)) {
                return newCryptogram;
            }

            cryptogram = newCryptogram;
        }
    }

    static String getCryptogram(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        int len = cryptogram.length();
        for (int i = 0; i < len; i++) {
            char target = cryptogram.charAt(i);

            if (stack.size() > 0 && stack.peek() == target) {
                stack.pop();
            }
            else {
                stack.add(target);
            }
        }

        return joinStack(stack);
    }

    static String joinStack(Stack<Character> stack) {
        List<Character> stackList = new ArrayList(stack);
        int size = stackList.size();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < size; i++) {
            result.append(stackList.get(i));
        }

        return result.toString();
    }

    // public static void main(String[] args) {
    //     String ex = "zyelleyz";
    //     String res = solution(ex);
    //     System.out.println(getCryptogram(res));
    //
    // }
}
