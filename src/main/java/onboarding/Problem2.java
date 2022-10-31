package onboarding;

import java.util.Deque;
import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        answer = dequeToString(decoding(cryptogram));
        return answer;
    }

    /**
     * 입력 받은 String을 deque에 뒤에서부터 한 문자씩 저장하며 연속된 중복값을 제거
     * @param {String} cryptogram
     * @return Deque<Character>
     */
    public static Deque<Character> decoding(String cryptogram) {
        Deque<Character> deque = new LinkedList<>();
        deque.addFirst(cryptogram.charAt(0));

        for (int i = 1; i < cryptogram.length(); i++) {
            if(!deque.isEmpty() && deque.peekLast() == cryptogram.charAt(i)) {
                while(!deque.isEmpty() && deque.peekLast() == cryptogram.charAt(i)) {
                    deque.pollLast();
                }
            }
            else deque.addLast(cryptogram.charAt(i));
        }

        return deque;
    }

    /**
     * deque의 요소들을 String으로 반환
     * @param {deque} deque
     * @return {String} convert
     */
    public static String dequeToString(Deque<Character> deque) {
        String convert = "";

        if(deque.isEmpty()) return convert;
        else {
            while(!deque.isEmpty()) convert += deque.pollFirst();
        }

        return convert;
    }

}
