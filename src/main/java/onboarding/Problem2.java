package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Deque<String> queue = new ArrayDeque<>(List.of(cryptogram.split("")));
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            if (queueSize == 1) {
                break;
            }
        }
        return answer;
    }
}
