package onboarding;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decode(cryptogram);
    }

    // deque의 last에서 중복 문자를 제거해서 암호문을 해독한다.
    private static String decode(String cryptogram) {
        Deque<Character> deque = new ArrayDeque<>();
        deque.addLast(cryptogram.charAt(0));

        for (int i = 1; i < cryptogram.length(); i++) {
            Character last = deque.peekLast();
            Character current = cryptogram.charAt(i);
            if (current.equals(last)) {
                deque.removeLast();
                continue;
            }
            deque.addLast(current);
        }

        return deque.stream().map(String::valueOf)
                .collect(Collectors.joining());
    }
}
