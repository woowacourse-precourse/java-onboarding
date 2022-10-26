package onboarding;

import java.util.ArrayDeque;

public class Problem2 {
    private static final int MIN_DECRYPT_LENGTH = 2;

    public static String solution(String cryptogram) {
        String result;

        while (true) {
            result = decrypt(cryptogram);
            if (cryptogram.equals(result)) {
                break;
            }
            cryptogram = result;
        }
        return result;
    }

    private static String decrypt(String cryptogram) {
        if (cryptogram.length() < MIN_DECRYPT_LENGTH) {
            return cryptogram;
        }

        ArrayDeque<Character> queue = new ArrayDeque<>();
        for (char c : cryptogram.toCharArray()) {
            if (queue.isEmpty() || queue.getLast() != c) {
                queue.addLast(c);
            } else {
                queue.pollLast();
            }
        }

        return queueToString(queue);
    }

    private static String queueToString(ArrayDeque<Character> queue) {
        StringBuilder sb = new StringBuilder();
        for (char c : queue) {
            sb.append(c);
        }
        return sb.toString();
    }
}
