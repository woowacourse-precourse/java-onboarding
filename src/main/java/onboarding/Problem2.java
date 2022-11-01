package onboarding;

import java.util.*;

public class Problem2 {
    static class Decrypt {
        Stack<Character> stack;
        StringBuilder sb;

        public Decrypt() {
            this.stack = new Stack<>();
            this.stack.push('/');
            this.sb = new StringBuilder();
        }

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
