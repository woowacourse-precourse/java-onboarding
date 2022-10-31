package onboarding;

import java.util.Stack;

public class Problem2 {

    public static boolean checkNotDuplicate(String string) {
        for (int i=1; i<string.length(); i++)  {
            if (string.charAt(i-1) == string.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkStackPop(Stack<Character> stack, String code, char before, int idx) {
        if (!stack.isEmpty() && before == code.charAt(idx)&& code.charAt(idx) == stack.peek()) {
            return true;
        }
        return false;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
