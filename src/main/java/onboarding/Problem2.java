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
            if (NotEmpty(stack) && (stack.peek() == ch)) {
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

    /** check할 필요없이 deleteDuplicate를 돌리면 중복문자가 있든 없든, 비밀번호는 나온다.
     * 하지만, for문으로 먼저 한 번 체크를 하면 굳이 stack을 만들면서, for문 돌고, StringBuilder를 만들 필요가 없기 때문에
     * 나는 check메소드가 있는 것이 더 좋다고 생각한다. */
    private static boolean checkDuplicate(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
    private static boolean NotEmpty(Stack<Character> stack) {
        return !stack.isEmpty();
    }
}
