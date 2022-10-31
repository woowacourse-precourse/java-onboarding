package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String decryption = "";

        while (true) {
            decryption = deleteDuplicate(cryptogram, cryptogram.length());

            if (cryptogram.equals(decryption)) break;

            cryptogram = decryption;
        }

        return decryption;
    }

    public static String deleteDuplicate(String cryptogram, int size) {
        Stack<Character> stack = new Stack<>();
        String decryption = "";

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
            decryption = stack.pop() + decryption;
        }

        return decryption;
    }

    public static int findlastDuplicateIndex(String cryptogram, int index) {
        char duplicatedCharacter = cryptogram.charAt(index);
        while (index < cryptogram.length()) {
            if (duplicatedCharacter != cryptogram.charAt(index)) {
                break;
            }

            index++;
        }

        return index - 1;
    }
}
