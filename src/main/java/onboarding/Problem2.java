package onboarding;

import java.util.Stack;

public class Problem2 {
    private static final Stack<Character> stack = new Stack<>();

    public static String solution(String cryptogram) {
        char removedLetter = '.';

        for (int index = 0 ; index < cryptogram.length() ; index++) {
            if (stack.isEmpty()) {
                stack.add(cryptogram.charAt(index));
            } else {
                removedLetter = removeDuplicateString(index, cryptogram, removedLetter);
            }
        }

        return getOriginalInformation();
    }

    private static char removeDuplicateString(int index, String cryptogram, char removedLetter) {
        if (stack.peek() == cryptogram.charAt(index)) {
            return stack.pop();
        } else  {
            stack.add(cryptogram.charAt(index));
            return removeOddDuplicateString(removedLetter);
        }
    }

    private static char removeOddDuplicateString(char removedLetter) {
        if (stack.peek() == removedLetter && removedLetter != '.') {
            return stack.pop();
        }

        return '.';
    }

    private static String getOriginalInformation() {
        StringBuilder cryptogram = new StringBuilder();

        while (!stack.isEmpty()) {
            cryptogram.append(stack.pop());
        }

        return cryptogram.reverse().toString();
    }
}
