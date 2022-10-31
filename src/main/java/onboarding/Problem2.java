package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        Deque<String> queue = new ArrayDeque<>(List.of(cryptogram.split("")));
        return String.join("", removeDuplicatedStr(queue));
    }

    private static Deque<String> removeDuplicatedStr(Deque<String> queue) {
        Deque<String> stack = new ArrayDeque<>();

        while (!queue.isEmpty()) {
            if (stack.isEmpty()) {
                stack.add(queue.pollFirst());
            }

            String previousChar = stack.getLast();
            boolean isDeleted = popDuplicatedChar(queue, previousChar);

            if (isDeleted) {
                stack.pollLast();
            }

            if (!isDeleted && !queue.isEmpty()) {
                stack.add(queue.pollFirst());
            }
        }

        return stack;
    }

    private static boolean popDuplicatedChar(Deque<String> queue, String previousChar) {
        boolean isDeleted = false;

        while (!queue.isEmpty() && previousChar.equals(queue.getFirst())) {
            queue.pollFirst();
            isDeleted = true;
        }

        return isDeleted;
    }
}
