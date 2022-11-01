package problem4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {

    @Test
    @DisplayName("반대 문자로 변경")
    void reverse() {
        assertEquals("R olev blf", new Word("I love you").reverse());
    }
}