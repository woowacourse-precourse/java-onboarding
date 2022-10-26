package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            char letter = cryptogram.charAt(i);
            if (stack.empty()) {
                stack.add(letter);
                continue;
            }

            boolean isDuplicated = false;
            Character lastLetter = stack.peek();
            while (cryptogram.charAt(i) == lastLetter) {
                isDuplicated = true;
                i += 1;
            }

            if (isDuplicated) {
                stack.pop();
                i -= 1;
            } else {
                stack.add(cryptogram.charAt(i));
            }
        }


        return answer;
    }
}
