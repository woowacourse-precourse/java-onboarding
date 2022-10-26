package onboarding.problem2;

import java.util.*;

public class TextDecoderV1 implements TextDecoder {
    String cipher;

    public TextDecoderV1(String cipher) {
        this.cipher = cipher;
    }

    @Override
    public String getCipher() {
        return cipher;
    }

    @Override
    public String getPlainText() {
        return decode();
    }

    private String decode() {
        String[] chars = cipher.split("");
        Stack<String> characterStack = new Stack<>();

        for (String chr : chars) {
            if (!characterStack.isEmpty() && characterStack.peek().equals(chr)) {
                characterStack.pop();
                continue;
            }
            characterStack.push(String.valueOf(chr));
        }
        return String.join("", characterStack);
    }
}
