package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {
    Problem4 problem4;

    @Test
    @DisplayName("알파벳 변환이 잘되는지")
    void changeAlphabet() {
        problem4 = new Problem4();
        assertEquals('D', problem4.changeAlphabet('W'));
        assertEquals('d', problem4.changeAlphabet('w'));
    }

}