package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {

    private static final int MIN_CRYPTO_LENGTH = 1;
    private static final int MAX_CRYPTO_LENGTH = 1000;

    public static String solution(String cryptogram) {
        if (validateCryptoSize(cryptogram)) {
            return "";
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
