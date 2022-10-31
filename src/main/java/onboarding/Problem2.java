package onboarding;

import java.util.Stack;

public class Problem2 {

    private final static int MIN_RANGE_NUM = 1;
    private final static int MAX_RANGE_NUM = 1000;

    public static String solution(String cryptogram) {
        validateRange(cryptogram);
        validateLower(cryptogram);

        String answer = decryptionGame(cryptogram);
        return answer;
    }

    private static String decryptionGame(String cryptogram) {
        while (true) {
            Stack<Character> stack = new Stack<>();
            int index = 0;
            int count = 0;
            boolean flag = false;
            boolean isEnd = true;

            while (index != cryptogram.length()) {
                if (!stack.empty()) {
                    if (stack.peek() == cryptogram.charAt(index)) {
                        flag= true;
                        isEnd = false;
                        count += 1;
                    } else {
                        if (flag) {
                            for (int i=0; i<=count; i++) {
                                stack.pop();
                            }
                            count = 0;
                            flag = false;
                        }
                    }
                }
                stack.add(cryptogram.charAt(index));
                index += 1;
            }

            if (flag) {
                for (int i=0; i<=count; i++) {
                    stack.pop();
                }
            }

            StringBuilder sb = new StringBuilder();
            for(char ch : stack) {
                sb.append(ch);
            }
            cryptogram = sb.toString();

            if (isEnd) break;
        }
        return cryptogram;
    }

    private static void validateRange(String input) {
        int inputLength = input.length();
        if (inputLength < MIN_RANGE_NUM || inputLength > MAX_RANGE_NUM) {
            throw new IllegalArgumentException("cryptogram은 길이가 1 이상 1000 이하인 문자열이다.");
        }
    }

    private static void validateLower(String input) {
        if (!input.toLowerCase().equals(input)) {
            throw new IllegalArgumentException("cryptogram은 알파벳 소문자로만 이루어져 있다.");
        }
    }
}
