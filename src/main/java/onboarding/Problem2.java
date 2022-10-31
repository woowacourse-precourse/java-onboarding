package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = decrypt(cryptogram);
        return answer;
    }

    static String decrypt(String cryptogram) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < cryptogram.length(); i++) {
            if (!stack.empty() && String.valueOf(cryptogram.charAt(i)).equals(stack.peek())) {
                stack.pop();
            } else {
                stack.push(String.valueOf(cryptogram.charAt(i)));
            }
        }
        String answer = stack.stream().map(String::valueOf).collect(Collectors.joining(""));
        return answer;
    }

}

