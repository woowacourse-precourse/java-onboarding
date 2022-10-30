package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    // 기능#3 문자열 순서대로 각 글자에 대해 기능#2을 실행하고, stack에 남은 글자들을 stack의 역순으로 꺼내어 합친 문자열을 반환하는 기능
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<Character>();

        // 기능#1 문자열을 한 글자씩 쪼개는 기능
        for(char character : cryptogram.toCharArray()) {
            if(stack.empty()){
                stack.push(character);
                continue;
            }

            // 기능#2 글자가 주어질 때, stack에 동일한 글자가 있으면 동일한 글자를 stack에서 제거하고, 없으면 주어진 글자를 stack에 넣는 기능
            if(stack.peek() == character)
                stack.pop();
            else
                stack.push(character);
        }

        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
