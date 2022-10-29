package onboarding;

import java.util.Stack;
/**
 *  구현할 기능 목록
 *      1. 암호문 해독 기능
 *          1.1 스택 peek와 중복되지 않을 경우 push
 *          1.2 스택 peek와 중복될 경우 pop
 */

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> plaintext = getPlaintext(cryptogram);

        StringBuilder sb = new StringBuilder();
        for (char ch : plaintext) {
            sb.append(ch);
        }

        return sb.toString();
    }

    // 암호문 해독
    private static Stack<Character> getPlaintext(String cryptogram){
        Stack<Character> plaintext = new Stack<>();
        for (char ch : cryptogram.toCharArray()) {
            if (plaintext.isEmpty()) {
                plaintext.push(ch);
                continue;
            }

            // 스택 peek와 중복되지 않을 경우 push
            if (plaintext.peek() != ch) {
                plaintext.push(ch);
            }
            else { // 스택 peek와 중복될 경우 pop
                plaintext.pop();
            }
        }
        return plaintext;
    }

}
