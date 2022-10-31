package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String password = "";

        while (true) {
            if (cryptogram.equals(password)) break;
        }

        return password;
    }

    public static String deleteDuplicate(String cryptogram, int size) {
        Stack<Character> stack = new Stack<>();
        String password = "";

        for (int i = 0; i < size; i++) {
            if (stack.isEmpty()) {
                stack.push(cryptogram.charAt(i));
                continue;
            }

            if (stack.peek() == cryptogram.charAt(i)) {
                // 마지막 중복값의 위치 구하기
                i = findlastDuplicateIndex(cryptogram, i);
                stack.pop();
                continue;
            }

            stack.push(cryptogram.charAt(i));
        }

        while (!stack.isEmpty()) {
            password = stack.pop() + password;
        }

        return password;
    }

    public static int findlastDuplicateIndex(String cryptogram, int index) {
        char target = cryptogram.charAt(index);
        while (index < cryptogram.length()) {
            if (target != cryptogram.charAt(index)) {
                break;
            }

            index++;
        }

        return index - 1;
    }
}
