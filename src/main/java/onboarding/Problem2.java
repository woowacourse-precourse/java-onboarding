package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decipher(cryptogram);
    }

    private static String decipher(String cryptogram) {
        if (cryptogram == null) {
            return null;
        }

        Deque<Character> queue = new ArrayDeque<>();
        char[] cryptogramToChar = cryptogram.toCharArray();

        for (char c: cryptogramToChar) {
            if (!queue.isEmpty() && queue.peekLast() == c) {
                queue.pollLast();
                continue;
            }
            queue.add(c);
        }

        return queueToString(queue);
    }

    private static String queueToString(Deque<Character> queue) {
        char[] result = new char[queue.size()];

        int k = 0;
        while (!queue.isEmpty()) {
            result[k++] = queue.poll();
        }

        return String.valueOf(result);
    }
}
