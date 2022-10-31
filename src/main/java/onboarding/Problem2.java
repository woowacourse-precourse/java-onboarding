package onboarding;

import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    public static String solution(String cryptogram) {
        Queue<Character> q = new LinkedList<>();
        Queue<Character> q2 = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cryptogram.length(); i++) {
            q.offer(cryptogram.charAt(i));
        }
        // 중복이 3개 이상일 수 있다.
        while (true) {
            int cnt = 0;
            while (!q.isEmpty()) {
                char now = q.poll();
                // q가 마지막인 경우
                if (q.isEmpty()) {
                    q2.offer(now);
                    continue;
                }
                char next = q.peek();
                // 중복인경우
                if (now == next) {
                    cnt++;
                    q.poll();
                    //중복을 모두 제거
                    while (!q.isEmpty()) {
                        next = q.peek();
                        if (now == next) {
                            q.poll();
                        } else {
                            break;
                        }
                    }
                } else {
                    q2.offer(now);
                }
            }
            q.addAll(q2);
            q2.clear();
            // 더이상 중복 문자가 없다.
            if (cnt == 0) {
                while (!q.isEmpty()) {
                    sb.append(q.poll());
                }
                break;
            }
        }
        return sb.toString();
    }
}
