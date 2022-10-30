package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {
    public static String solution(String cryptogram) {
        Deque<Character> dq1 = new ArrayDeque<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            dq1.addLast(cryptogram.charAt(i));
        }
        //중복 문자열 삭제하기
        int pre;
        do {
            pre = dq1.size();
            if (pre == 0) {
                break;
            }
            Deque<Character> dq2 = new ArrayDeque<>();
            dq2.addLast(dq1.pollFirst());
            while (!dq1.isEmpty()) {
                if (dq2.peekLast() == dq1.peekFirst()) {
                    while (dq2.peekLast() == dq1.peekFirst()) {
                        dq1.pollFirst();
                    }
                    dq2.pollLast();
                }
                if(dq2.peekLast() != dq1.peekFirst()) {
                    dq2.addLast(dq1.pollFirst());
                }
            }
            dq1 = dq2;
        } while (pre != dq1.size());
        //결과 리턴
        if (pre == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : dq1) {
            sb.append(character);
        }
        return sb.toString();

    }
}
