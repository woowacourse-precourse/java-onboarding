package onboarding.problem2.domain;

import java.util.ArrayDeque;

public class Decoder {

    public String decode(Cryptogram cryptogram) {
        ArrayDeque<Character> cryptoStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (char c : cryptogram.toCharArray()) {
            if (cryptoStack.isEmpty()) {
                cryptoStack.add(c);
                continue;
            }
            Character character = cryptoStack.removeLast();
            if (c != character) {
                cryptoStack.add(character);
                cryptoStack.add(c);
            }
        }
        cryptoStack.forEach(sb::append);
        return sb.toString();
    }
}

