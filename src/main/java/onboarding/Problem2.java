package onboarding;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = stackToString(decrypt(cryptogram));
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

    private static String stackToString(Stack<Character> stack) {
        String str = "";
        for (Character c : stack) {
            str += String.valueOf(c);
        }
        return str;
    }


}