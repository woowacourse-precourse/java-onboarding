package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.InputMismatchException;

public class Problem2 {

    static class Cryptogram {

        private String value;
        private final int START_RANGE = 1;
        private final int END_RANGE = 1_000;


        public Cryptogram(String str) {
            if (!isValidLength(str)) {
                throw new InputMismatchException("입력된 문자열의 크기가 [1,1000] 이내가 아닙니다.");
            }
            this.value = str;
        }

        private boolean isValidLength(String str) {
            return START_RANGE <= str.length() && str.length() <= END_RANGE;
        }


        private String removeDuplicates(String cryptogram) {
            Deque<Character> deque = new ArrayDeque<>();
            for (char ch : cryptogram.toCharArray()) {
                enrichDeque(deque, ch);
            }
            return dequeToStr(deque);
        }

        private void enrichDeque(Deque<Character> deque, char ch) {
            if (!Character.isLowerCase(ch)) {
                throw new InputMismatchException("영문자 소문자가 아닌 입력이 들어왔습니다.");
            }

            if (isDuplicates(deque, ch)) {
                deque.removeLast();
                return;
            }

            deque.addLast(ch);
        }

        private boolean isDuplicates(Deque<Character> deque, char ch) {
            return !deque.isEmpty() && deque.getLast() == ch;
        }

        private String dequeToStr(Deque<Character> deque) {
            StringBuffer stringBuffer = new StringBuffer();

            while (!deque.isEmpty()) {
                stringBuffer.append(deque.getFirst());
                deque.removeFirst();
            }
            return stringBuffer.toString();
        }

        public String result() {
            return removeDuplicates(value);
        }
    }

    public static Cryptogram makeCryptogram(String str) {
        return new Cryptogram(str);
    }


    public static String solution(String cryptogram) {
        return makeCryptogram(cryptogram).result();
    }
}
