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
            calculateCharacterTo(chr, characterStack);
        }

        return String.join("", characterStack);
    }

    private void calculateCharacterTo(String chr, Stack<String> characterStack) {
        if (!characterStack.isEmpty() && characterStack.peek().equals(chr)) {
            characterStack.pop();
        } else {
            characterStack.push(String.valueOf(chr));
        }
    }
}
