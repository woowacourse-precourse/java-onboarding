package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        return deleteRepeat(cryptogram);
    }

    private static String deleteRepeat(String cryptogram) {
        String result = "";
        Stack<Character> deleteStack = new Stack<>();
        for (Character word : cryptogram.toCharArray()) {
            if (!deleteStack.isEmpty() && deleteStack.peek() == word) {
                deleteStack.pop();
            } else
                deleteStack.push(word);
        }

        for (int i = 0; i < deleteStack.size(); i++)
            result = result + deleteStack.get(i);

        return result;
    }
}
