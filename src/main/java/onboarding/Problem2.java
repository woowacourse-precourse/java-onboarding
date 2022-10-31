package onboarding;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class Problem2 {
    /*
    기능 목록
    1. 중복 문자 제거 기능
     */
    public static String solution(String cryptogram) {
        return decrypt(cryptogram);
    }

    // deque의 last에서 중복 문자를 제거해서 암호문을 해독한다.
    private static String decrypt(String cryptogram) {
        Deque<Character> deque = new ArrayDeque<>();
        deque.addLast(cryptogram.charAt(0));
        int sequenceCount = 0;
        for (int i = 1; i < cryptogram.length(); i++) {
            Character last = deque.peekLast();
            Character current = cryptogram.charAt(i);
            if (current.equals(last)) {
                sequenceCount++;
                continue;
            }
            if (sequenceCount > 0) {
                deque.removeLast();
                sequenceCount = 0;
            }
            if (current.equals(deque.peekLast())) {
                sequenceCount++;
                continue;
            }
            deque.addLast(current);
        }
        if (sequenceCount > 0) {
            deque.removeLast();
        }
        return deque.stream().map(String::valueOf)
                .collect(Collectors.joining());
    }
}
