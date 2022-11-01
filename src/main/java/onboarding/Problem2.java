package onboarding;

import java.util.*;

public class Problem2 {

    /**
     * 암호 해독기 클래스
     */
    static class Decrypt {
        Stack<Character> stack;
        StringBuilder sb;

        /**
         * 해독기 클래스 생성자.
         */
        public Decrypt() {
            this.stack = new Stack<>();
            this.stack.push('/');
            this.sb = new StringBuilder();
        }

        /**
         * 암호 해독 메소드
         */
        public String decrypt(String cryptogram) {
            int strLen = cryptogram.length();

            for (int i = 0; i < strLen; i++) {
                Character c = cryptogram.charAt(i);

                if (this.stack.peek() == c) {
                    this.stack.pop();
                } else {
                    this.stack.push(c);
                }
            }

            return result();
        }

        /**
         * 암호 해독 결과 메소드
         */
        private String result() {
            int stackLen = this.stack.size();
            for (int i = 1; i < stackLen; i++) {
                this.sb.append(this.stack.pop());
            }

            return this.sb.reverse().toString();
        }
    }

    public static String solution(String cryptogram) {
        Decrypt decrypt = new Decrypt();
        return decrypt.decrypt(cryptogram);
    }
}
