package onboarding;

import java.util.Deque;
import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        Deque<Character> dq = new LinkedList<>();
        char[] arr = cryptogram.toCharArray();

        for (int i = 0; i < arr.length;) {
            if (dq.isEmpty() || dq.getLast()!=arr[i]) {
                dq.add(arr[i]);
                i++;
                continue;
            }
            while (!dq.isEmpty() && dq.getLast()==arr[i]) {
                dq.removeLast();
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.removeFirst());
        }

        return sb.toString();
    }
}
