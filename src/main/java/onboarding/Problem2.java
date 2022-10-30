package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        char tmp = 'X';
        StringBuilder answer = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        char[] charArr = cryptogram.toCharArray();

        if (!isAlphabet(cryptogram) || !isLowerAlphabet(cryptogram) || !isOutOfRange(cryptogram)) {
            return "";
        }

        for (char c : charArr) {
            if (stack.isEmpty()) {
                stack.push(c);
                if (tmp == c) {
                    stack.pop();
                    continue;
                }
                tmp = 'X';
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                    tmp = c;
                } else {
                    stack.push(c);
                    if (tmp == c) {
                        stack.pop();
                        continue;
                    }
                    tmp = 'X';
                }
            }
        }

        for (char c : stack) {
            answer.append(c);
        }

        return answer.toString();
    }

    // validtaion 순서 : 범위에 맞는지 -> 문자열인지 -> 대소문자인지

    private static boolean isAlphabet(String cryptogram) {
        boolean result = true;
        for (int i = 0; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) < 'a' || cryptogram.charAt(i) > 'z') {
                result = false;
                break;
            }
        }
        return result;
    }

    private static boolean isLowerAlphabet(String cryptogram) {
        String modified = cryptogram.toLowerCase();
        return cryptogram.equals(modified); // lower로 바꾼 것과 바꾸기 전의 값이 다르다면 대문자가 섞여 있었다는 뜻.
    }

    private static boolean isOutOfRange(String cryptogram) {
        return cryptogram.length() >= 1 && cryptogram.length() <= 4000;
    }
}
