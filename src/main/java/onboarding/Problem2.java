package onboarding;

import java.util.*;
import java.io.*;

public class Problem2 {
    static class Decryptor{
        Stack<Character> stack;

        public Decryptor(char initChar) {
            this.stack = new Stack<>();
            this.stack.push(initChar);
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
    }

    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        stack.push('/');
        int strLen = cryptogram.length();

        for (int i = 0; i < strLen; i++) {
            Character c = cryptogram.charAt(i);

            if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        int stackLen = stack.size();
        for (int i = 1; i < stackLen; i++) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
