package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = firstDuplication(cryptogram);
        return answer;
    }
    private static String firstDuplication(String cryptogram) {
        //입력받은 문자열의 중복을 1차적으로 제거
        for (int i = 0; i < cryptogram.length(); i++) {
            int cnt = 1;
            while (i + cnt < cryptogram.length() && cryptogram.charAt(i) == cryptogram.charAt(i + cnt)) {
                cnt++;
            }
            if(cnt > 1) {
                cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + cnt);
                i = i - 1;
            }
        }
        return stringDeduplication(cryptogram);
    }

    private static String stringDeduplication(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        char[] alphabets = getAlphabets(cryptogram);
        for (int i = 0; i < alphabets.length; i++) {
            char alphabet = alphabets[i];
            if (!stack.isEmpty()) {
                // peek 한 값이 값과 같으면 pop
                if (stack.peek() == alphabets[i]) {
                    stack.pop();
                } else {
                    stack.push(alphabet);
                }
            } else {
                stack.push(alphabet);
            }
        }
        return makeStackToString(stack);
    }
    private static String makeStackToString(Stack<Character> stack) {
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        return answer.reverse().toString();
    }

    private static char[] getAlphabets(String cryptogram) {
        return cryptogram.toCharArray();
    }
}
