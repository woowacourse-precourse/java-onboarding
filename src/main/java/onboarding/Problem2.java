package onboarding;

import java.util.*;
import java.io.*;

public class Problem2 {
    static class Decryptor{
        Stack<Character> stack;
        StringBuilder sb;

        public Decryptor(char initChar) {
            this.stack = new Stack<>();
            this.stack.push(initChar);
            this.sb = new StringBuilder();
        }

        public Decryptor decrypto(String cryptogram) {
            int strLen = cryptogram.length();

            for (int i = 0; i < strLen; i++) {
                Character c = cryptogram.charAt(i);

                if (this.stack.peek() == c) {
                    this.stack.pop();
                } else {
                    this.stack.push(c);
                }
            }

            return this;
        }

        public String result() {
            int stackLen = this.stack.size();
            for (int i = 1; i < stackLen; i++) {
                this.sb.append(this.stack.pop());
            }

            return this.sb.reverse().toString();
        }
    }

    public static String solution(String cryptogram) {
        Decryptor decryptor = new Decryptor('/');
        return decryptor.decrypto(cryptogram).result();
    }
}
