package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = deleteRepeat(cryptogram);
        return answer;
    }

    private static String deleteRepeat(String cryptogram) {
        String Result = "";
        Stack<Character> deleteStack = new Stack<>();
        for (Character x : cryptogram.toCharArray()) {
            if (!deleteStack.isEmpty() && deleteStack.peek() == x) {
                deleteStack.pop();
            } else
                deleteStack.push(x);
        }

        for (int i = 0; i < deleteStack.size(); i++)
            Result = Result + deleteStack.get(i);

        return Result;
    }
}
