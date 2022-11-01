package onboarding;

import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    private static Queue<Character> queue = new LinkedList<>();

    public static String solution(String cryptogram) {
        queue.clear();
        initializeQueue(cryptogram);
        int count;
        while (true) {
            count = deleteInQueue();
            if (count == 0) {
                break;
            }
        }

        String answer = queueToString();
        return answer;
    }


    private static void initializeQueue(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            char nowChar = cryptogram.charAt(i);
            queue.offer(nowChar);
        }
    }

    private static int deleteInQueue() {
        int count = 0;
        int size = queue.size();

        if (size <= 1) {
            return 0;
        }

        char nowChar;
        char nextChar;
        char recentDuplicateChar = ' ';

        for (int i = 0; i < size; i++) {
            nowChar = queue.poll();

            if (recentDuplicateChar == nowChar) {
                count++;
                continue;
            }

            if (i == size - 1) {
                queue.offer(nowChar);
                continue;
            }

            nextChar = queue.peek();
            if (nowChar == nextChar) {
                recentDuplicateChar = nowChar;
                count++;
                continue;
            }

            recentDuplicateChar = ' ';
            queue.offer(nowChar);
        }

        return count;
    }

    private static String queueToString() {
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
