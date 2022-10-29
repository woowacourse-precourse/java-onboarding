package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = deleteDupChar(cryptogram);
        return answer;
    }

    private static String deleteDupChar(String string) {
        Stack<Character> stack = new Stack<Character>();
        stack.push(string.charAt(0));
        for(int i = 1; i < string.length(); i++) {
            if(stack.peek().equals(string.charAt(i))) {
                stack.pop();
                continue;
            }
            stack.push(string.charAt(i));
        }
        return stack.stream()
                .map(a -> a.toString())
                .collect(Collectors.joining(""));
    }
}

/*
 TODO
 3개 이상 중복될 경우? ex) browooon 시 browon 출력 되는 오류
*/
