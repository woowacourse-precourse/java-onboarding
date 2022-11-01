package onboarding;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }


    private static Stack<Character> decrypt(String text) {
        Stack<Character> decryptionStack = new Stack<>();
        Character beforeChar, nowChar, beforeRemovedChar = null;
        decryptionStack.push(text.charAt(0));
        for (int i = 1; i < text.length(); i++) {
            beforeChar = decryptionStack.peek();
            nowChar = text.charAt(i);
            if (beforeRemovedChar != null && nowChar.equals(beforeRemovedChar)) {
                continue;
            }
            if (!beforeChar.equals(nowChar)) {
                decryptionStack.push(nowChar);
            } else if (beforeChar.equals(nowChar)) {
                beforeRemovedChar = decryptionStack.pop();
            }
        }
        return decryptionStack;
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