package problem3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClapsTest {

    @Test
    @DisplayName("number까지 손뼉 수 계산")
    void clap() {
        int number = 33;
        Claps claps = new Claps(new int[number + 1]);
        assertEquals(14, claps.clap());
    }
}