package onboarding;

import java.util.Stack;

public class Problem2 {

    public static void main(String[] args) {
        System.out.println(solution("browoanoommnaon"));
        System.out.println(solution("zyelleyz"));
    }

    public static String solution(String cryptogram) {

        if(checkDuplicate(cryptogram)) {
            cryptogram = deleteDuplicate(cryptogram);
        }

        return cryptogram;
    }

    private static String deleteDuplicate(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        for (char ch : cryptogram.toCharArray()) {
            if (!stack.isEmpty() && (stack.peek() == ch)) {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    private static boolean checkDuplicate(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
}
