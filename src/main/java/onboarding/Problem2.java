package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Stack<Character> nonDuplicates = decryption(cryptogram);
        answer = concatStack(nonDuplicates);
        return answer;
    }

    private static Stack<Character> decryption(String input) {
        Stack<Character> result = new Stack<>();
        Character duplicate = null;

        for (int i = 0; i < input.length(); i++) {
            Character cur = input.charAt(i);

            if (result.isEmpty() && duplicate == null) {
                result.push(cur);
                continue;
            }

            if (!result.isEmpty() && result.peek() == cur) {
                duplicate = cur;
                result.pop();
                continue;
            }

            if (duplicate != cur) {
                result.push(cur);
            }
        }

        return result;
    }

    private static String concatStack(Stack<Character> nonDuplicates) {
        StringBuilder concatString = new StringBuilder();

        for (Character nonDuplicate : nonDuplicates) {
            concatString.append(nonDuplicate);
        }

        return concatString.toString();
    }

}
