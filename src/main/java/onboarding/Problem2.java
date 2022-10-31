package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        return newCryptogram(popOverlap(cryptogram));
    }

    // 중복되는 문자를 제거
    public static Stack<Character> popOverlap(String cryptogram) {
        Stack<Character> cryptogramStack = new Stack<>();
        for (int i = 0; i < cryptogram.length(); i++) {
            if (cryptogramStack.isEmpty()) {
                cryptogramStack.add(cryptogram.charAt(i));
                continue;
            }
            if (cryptogramStack.peek() == cryptogram.charAt(i)) {
                cryptogramStack.pop();
            } else {
                cryptogramStack.add(cryptogram.charAt(i));
            }
        }
        return cryptogramStack;
    }

    // 제거 후 문자를 String 형태로 반환
    public static String newCryptogram(Stack<Character> cryptogramStack) {
        StringBuffer newCryptogram = new StringBuffer();
        for (int i = 0; i < cryptogramStack.size(); i++) {
            newCryptogram.append(cryptogramStack.elementAt(i));
        }
        return newCryptogram.toString();
    }
}