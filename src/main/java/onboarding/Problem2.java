package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = stackToString(decrypt(cryptogram));
        return answer;

    }

    // 암호 해독하여 스택에 저장
    private static Stack<Character> decrypt(String cryptogram) {
        Stack<Character> decryptionStack = new Stack<>();
        decryptionStack.push(cryptogram.charAt(0));
        Character beforeChar, nowChar, beforeRemovedChar = null;

        for (int i = 1; i < cryptogram.length(); i++) {
            beforeChar = decryptionStack.peek();
            nowChar = cryptogram.charAt(i);
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

    // 스택에서 해독문 추출
    private static String stackToString(Stack<Character> stack) {
        String str = "";
        for (Character c : stack) {
            str += String.valueOf(c);
        }
        return str;
    }


}