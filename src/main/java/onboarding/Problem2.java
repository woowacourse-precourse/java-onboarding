package onboarding;

import java.util.Stack;
import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        int prevSize = 0;
        int reversed = -1;
        Stack<Character> stack = makeStack(cryptogram);
        StringBuilder sb = new StringBuilder();

        while (prevSize != stack.size()) {
            prevSize = stack.size();
            stack = removeDuplication(stack);
            reversed *= -1;
        }
        if (reversed == -1) {
            stack = reverseAnswer(stack);
        }
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static Stack<Character> reverseAnswer(Stack<Character> stack) {
        Stack<Character> temp = new Stack<>();
        while (!stack.empty()) {
            temp.push((char)stack.pop());
        }
        return temp;
    }

    private static Stack<Character> makeStack(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        char[] ch = cryptogram.toCharArray();
        for (char cur : ch) {
            stack.push(cur);
        }
        return stack;
    }

    public static Stack<Character> removeDuplication(Stack<Character> stack) {
        int isPrevSame = 0;
        Stack<Character> removed = new Stack<>();
        ArrayList<Object> args = new ArrayList<>();
        args = makeArgs(stack, removed, isPrevSame);
        while (!stack.empty()) {
            stack = (Stack<Character>)args.get(0);
            removed = (Stack<Character>)args.get(1);
            isPrevSame = (Integer)args.get(2);
            args = remove(stack, removed, isPrevSame);
        }
        if ((Integer)args.get(2) == 1) {
            removed.pop();
        }
        return removed;
    }

    public static ArrayList remove(Stack<Character> stack, Stack<Character> removed, int isPrevSame) {
        ArrayList<Object> args = new ArrayList<>();
        char cur = stack.pop();
        if (removed.empty()) {
            removed.push(cur);
            return makeArgs(stack, removed, isPrevSame);
        }
        if (removed.peek() == cur) {
            removed.pop();
            isPrevSame = 1;
            removed.push(cur);
            return makeArgs(stack, removed, isPrevSame);
        }
        if (isPrevSame == 1) {
            removed.pop();
        }
        isPrevSame = 0;
        removed.push(cur);
        return makeArgs(stack, removed, isPrevSame);
    }

    public static ArrayList makeArgs(Stack<Character> stack, Stack<Character> removed, int isPrevSame) {
        ArrayList<Object> args = new ArrayList<>();
        args.add(stack);
        args.add(removed);
        args.add(isPrevSame);
        return args;
    }
}

