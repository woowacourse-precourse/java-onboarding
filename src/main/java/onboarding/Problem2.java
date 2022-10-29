package onboarding;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Stack<Character> charStack = StringToCharStack(cryptogram);
        return answer;
    }

    protected static Stack<Character> StringToCharStack(String text) {
        Stack<Character> charStack = new Stack<>();
        final int TEXT_LENGTH = text.length();
        for (int i = 0; i < TEXT_LENGTH; i++) {
            charStack.push(text.charAt(i));
        }
        return charStack;
    }

    protected static String CharsToString(List<Character> chars) {
        Stream<Character> charStream = chars.stream();
        String text = charStream.map(String::valueOf).collect(Collectors.joining());
        return text;
    }
}
