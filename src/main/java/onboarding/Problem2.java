package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {
    public static String solution(String cryptogram) {
        return removeDuplicateString(cryptogram);
    }

    public static String removeDuplicateString(String str) {
        Stack<Character> stack = new Stack<>();
        str.chars().forEach(i -> {
            if (!stack.isEmpty() && stack.peek() == i) {
                stack.pop();
            } else
                stack.push((char) i);
        });
        return charStackToString(stack);
    }

    public static String charStackToString(Stack<Character> stack) {
        return stack.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
/*
문제 설명
  1. 임의의 문자열 cryptogram이 주어짐
  2. 연속하는 중복 문자들을 삭제한 결과를 리턴함

문제 예시
  1. "browoanoommnaon" => "oomm" 제거
  2. "browoannaon" => "nn" 제거
  3. "browoaaon" => "aa" 제거
  4. "browoon" => "oo" 제거
  5. "brown" => 리턴

제한사항 및 주의할점
  - cryptogram은 길이가 1 이상 1000 이하인 문자열
  - cryptogram은 알파벳 소문자로만 이루어짐
 */