package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<Character> cryptogramStack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            char currentIndex = cryptogram.charAt(i);
            if (cryptogramStack.isEmpty() || cryptogramStack.peek() != currentIndex) {
                cryptogramStack.push(currentIndex);
            } else {
                cryptogramStack.pop();
                while (i + 1 < cryptogram.length() && currentIndex == cryptogram.charAt(i + 1)) {
                    i++;
                }
            }
        }

        return cryptogramStack.stream()
            .map(Object::toString)
            .collect(Collectors.joining());
    }
}
