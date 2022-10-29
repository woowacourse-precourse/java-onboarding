package onboarding;

import java.util.*;
import java.io.*;

public class Problem2 {
    public static void main(String[] args) {
        String str = "browoanoommnaon";
        System.out.println(solution(str));
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
            System.out.println(sb.toString());
        }

        return sb.reverse().toString();
    }
}
