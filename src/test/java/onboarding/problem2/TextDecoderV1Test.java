package onboarding.problem2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextDecoderV1Test {

    @Test
    void getCipher() {
        String string = "Hello";
        TextDecoder decoder = new TextDecoderV1(string);

        assertEquals(string, decoder.getCipher());
    }

    @Test
    void getPlainText() {
        String string = "Hello";
        TextDecoder decoder = new TextDecoderV1(string);

        assertEquals("Heo", decoder.getPlainText());
    }
}