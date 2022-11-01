package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (!cryptogram.matches("^[a-z]*$")) {
            return "false";
        }
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            return "false";
        }

        return getDecrypto(cryptogram);
    }

    private static String getDecrypto(String cryptogram) {
        StringBuilder decryptionMessage = new StringBuilder();
        Stack<Character> cryptor = new Stack<>();

        char recodeCrypto = Character.MIN_VALUE;

        for (char crypto : cryptogram.toCharArray()) {
            if (crypto == recodeCrypto) {
                continue;
            }
            if (!cryptor.isEmpty() && cryptor.peek() == crypto) {
                cryptor.pop();
                recodeCrypto = crypto;
                continue;
            }

            cryptor.push(crypto);
        }

        cryptor.forEach(decryptionMessage::append);

        return decryptionMessage.toString();
    }
}
