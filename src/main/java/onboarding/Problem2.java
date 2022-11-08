package onboarding;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        Stack<String> s = new Stack<>();

        s.push(cryptogram.substring(0, 1));

        for (int i = 1; i < cryptogram.length(); i++) {
            String current = cryptogram.substring(i, i + 1);
            if (s.peek().equals(current)) {
                s.pop();
            } else {
                s.push(current);
            }
        }

        answer = Arrays.stream(s.toArray())
                .map(Object::toString)
                .collect(Collectors.joining());

        return answer;
    }
}
