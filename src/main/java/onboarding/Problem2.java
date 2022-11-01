package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        int prevSize = 0;
        int reversed = -1;
        Stack<Character> stack = makeStack(cryptogram);

        return answer;
    }

    private static Stack<Character> makeStack(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        char[] ch = cryptogram.toCharArray();
        for (char cur : ch) {
            stack.push(cur);
        }
        return stack;
    }

    private static Stack<Character> removeDuplication(Stack<Character> stack) {
        int i = 0;
        int isPrevSame = 0;
        Stack<Character> removed = new Stack<>();

        while (!stack.empty()) {
            char cur = stack.pop();
            if (removed.empty()) {
                removed.push(cur);
                continue;
            }
            if (removed.peek() == cur) {
                removed.pop();
                isPrevSame = 1;
                removed.push(cur);
                continue;
            }
            if (isPrevSame == 1) {
                removed.pop();
            }
            isPrevSame = 0;
            removed.push(cur);
        }
        if (isPrevSame == 1) {
            removed.pop();
        }
        return removed;
    }

    private static void checkPrev(Stack<Character> stack, Stack<Character> removed) {
        char cur = stack.pop();
        char prev = removed.peek();

    }
}

