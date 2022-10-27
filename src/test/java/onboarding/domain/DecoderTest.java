package onboarding.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {

    @Test
    @DisplayName("중복된 문자 제거 - 성공")
    void 중복된_문자_제거_성공() {
        Decoder decoder = new Decoder("aabbcc");
        assertEquals("", decoder.getDecodeResult());
    }

    @Test
    @DisplayName("중복된 문자 제거 - 실패")
    void 중복된_문자_제거_실패() {
        String beforeDecode = "hitechcourse";
        Decoder decoder = new Decoder(beforeDecode);
        assertEquals(beforeDecode, decoder.getDecodeResult());
    }

    @Test
    @DisplayName("중복된 문자 제거 - 반복 수행")
    void 중복된_문자_제거_반속_수행() {
        String beforeDecode = "wooowatechcource";
        Decoder decoder = new Decoder(beforeDecode);
        assertEquals("atechcource", decoder.getDecodeResult());
    }
}