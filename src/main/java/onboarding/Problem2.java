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
        String result = decrypt(cryptogram);
        String prevResult = cryptogram;
        while (!result.equals(prevResult) && !result.equals("")) {
            prevResult = result;
            result = decrypt(result);
        }
        return result;
    }

    // deque의 last에서 중복 문자를 제거해서 암호문을 해독한다.
    private static String decrypt(String cryptogram) {
        Deque<Character> deque = new ArrayDeque<>();
        deque.addLast(cryptogram.charAt(0));
        boolean isSequence = false;
        for (int i = 1; i < cryptogram.length(); i++) {
            Character last = deque.peekLast();
            Character current = cryptogram.charAt(i);
            if (current.equals(last)) {
                isSequence = true;
                continue;
            }
            if (isSequence) {
                deque.removeLast();
                isSequence = false;
            }
            deque.addLast(current);
        }
        if (isSequence) {
            deque.removeLast();
        }
        return deque.stream().map(String::valueOf)
                .collect(Collectors.joining());
    }
}
