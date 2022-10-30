package onboarding;

import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {

    // stack을 이용해 중복 문자를 제거
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>(); // stack 선언
        char[] charArr = cryptogram.toCharArray(); // 입력받은 str을 char 배열로 변환

        for (char ch: charArr) { // 변환한 char 배열 하나씩 순환
            // stack에 값이 존재하거나 최근 값이 현재 문자와 같으면 이 값을 stack에서 제거하고 현재 문자를 stack에 넣지 않는다.
            if (!stack.isEmpty() && stack.peek() == ch) stack.pop();
            else stack.push(ch);
        }

        // stack을 문자열로 변환해 반환
        return stack.stream().map(Objects::toString).collect(Collectors.joining());
    }
}