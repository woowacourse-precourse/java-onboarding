package onboarding;

import java.util.Stack;

public class Problem2 {
    /**
     * 암호문을 input으로 전달하면 복호화하여 리턴하는 메서드이다.
     *
     * @param : String, 암호문
     * @return : String, 복호화된 문자열
     */
    public static String solution(String cryptogram) {
        String answer = decrypt(cryptogram);
        return answer;
    }

    /**
     * 암호문을 복호화하는 메서드이다.
     *
     * @param : String, 암호문
     * @return : String, 복호화된 문자열
     */
    public static String decrypt(String encrypt) {
        Stack<Character> stack = new Stack<>();
        boolean isNotEnd = true;

        while (isNotEnd) {
            StringBuilder result = new StringBuilder();
            isNotEnd = false;

            for (int idx = 0, size = encrypt.length(); idx < size; idx++) {
                char currentChar = encrypt.charAt(idx);

                if (stack.isEmpty()) stack.push(currentChar);
                else if (stack.peek() != currentChar) stack.push(currentChar);
                else if (stack.peek() == currentChar) {
                    isNotEnd = true;
                    while (!stack.isEmpty() && stack.peek() == currentChar) stack.pop();
                }
            }

            while (!stack.isEmpty()) result.append(stack.pop());
            result.reverse();

            encrypt = result.toString();
        }

        return encrypt;
    }
}
