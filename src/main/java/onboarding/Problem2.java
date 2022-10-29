package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Decrypter decrypter = Decrypter.getInstance();
        String answer = decrypter.decrypt(cryptogram);
        return answer;
    }
}

class Decrypter {

    private static class DecrypterHolder {
        private static final Decrypter INSTANCE = new Decrypter();
    }

    private Decrypter() {
    }

    public static Decrypter getInstance() {
        return DecrypterHolder.INSTANCE;
    }

    public String decrypt(String cryptogram) {
        Stack<Character> chars = new Stack<>();

        for (int len = cryptogram.length(), i = 0; i < len; i++) {
            char current = cryptogram.charAt(i);

            if (isDuplicated(chars, current)) {
                chars.pop();
                continue;
            }

            chars.push(current);
        }

        String decrypted = stringOf(chars);
        return decrypted;
    }

    private boolean isDuplicated(Stack<Character> chars, char current) {
        if (chars.isEmpty()) {
            return false;
        }

        return chars.peek() == current;
    }

    private String stringOf(Stack<Character> chars) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char current : chars) {
            stringBuilder.append(current);
        }

        return stringBuilder.toString();
    }

}