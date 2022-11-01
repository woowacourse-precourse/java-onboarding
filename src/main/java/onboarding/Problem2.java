package onboarding;

import java.util.Stack;

public class Problem2 {
    static StringBuilder result;
    static Stack<Character> decrypt(String cryptogram) {
        char [] decryption = cryptogram.toCharArray();
        Stack<Character> stack = new Stack<>();
        int decryptionPos = 0;
        int stackPos = 1;

        stack.add(decryption[decryptionPos++]);
        while(true) {
            stack.add(decryption[decryptionPos++]);
            if(stack.size() > 1 && stack.get(stackPos) == stack.get(stackPos - 1)) {
                stack.pop();
                stack.pop();
                stackPos -= 1;
            }else {
                stackPos++;
            }
            if(decryptionPos == decryption.length) {
                break;
            }
        }

        return stack;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        result = new StringBuilder();
        for(Character c : decrypt(cryptogram)) {
            result.append(c);
        }
        answer = result.toString();
        return answer;
    }
}
