package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {

    private static final int MIN_CRYPTO_LENGTH = 1;
    private static final int MAX_CRYPTO_LENGTH = 1000;

    public static String solution(String cryptogram) {
        if (validateCryptoSize(cryptogram)) {
            throw new IllegalArgumentException("유효한 암호문의 길이를 입력해 주세요. (1 ~ 1000자)");
        }

        return decrypt(cryptogram.toLowerCase());
    }

    private static String decrypt(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        char prev = ' ';

        for (int i = 0; i < cryptogram.length(); i++) {
            char cur = cryptogram.charAt(i);

            if (!stack.isEmpty() && stack.peek() == cur) {
                stack.pop();
                prev = cur;
            }

            if (prev != cur) {
                stack.push(cur);
                prev = ' ';
            }
        }

        return stack.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    private static boolean validateCryptoSize(String cryptogram) {
        return cryptogram.length() < MIN_CRYPTO_LENGTH || cryptogram.length() > MAX_CRYPTO_LENGTH;
    }
}
