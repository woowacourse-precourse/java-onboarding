package problem2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {

    @Test
    @DisplayName("연속된 중복 문자 제거")
    void decode() {
        assertEquals("",
                new Decoder("aabb").decode());
        assertEquals("brown",
                new Decoder("browoanoommnaon").decode());
        assertEquals("",
                new Decoder("zyelleyz").decode());
    }
}