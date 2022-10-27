package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        Deque<String> queue = new ArrayDeque<>(List.of(cryptogram.split("")));

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            if (queueSize == 1) {
                break;
            }

            queue = removeDuplicatedStr(queue);

            if (isFinished(queue, queueSize)) {
                break;
            }
        }

        return String.join("", queue);
    }

    private static Deque<String> removeDuplicatedStr(Deque<String> queue) {
        Deque<String> tempQueue = new ArrayDeque<>();
        String previousChar = queue.pollFirst();

        while (!queue.isEmpty()) {
            boolean isDeleted = popDuplicatedChar(queue, previousChar);
            if (!isDeleted) {
                tempQueue.add(previousChar);
            }

            if (queue.isEmpty()) {
                break;
            }

            previousChar = queue.pollFirst();
            if (queue.isEmpty()) {
                tempQueue.add(previousChar);
            }
        }

        return tempQueue;
    }

    private static boolean popDuplicatedChar(Deque<String> queue, String targetStr) {
        boolean isDeleted = false;

        while (!queue.isEmpty() && targetStr.equals(queue.getFirst())) {
            queue.pollFirst();
            isDeleted = true;
        }

        return isDeleted;
    }

    private static boolean isFinished(Deque<String> tempQueue, int queueSize) {
        return queueSize == tempQueue.size();
    }
}
