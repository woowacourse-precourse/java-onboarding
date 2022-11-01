package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("청개구리 규칙에 맞게 단어가 변환되는지")
    void keepFrogRule() {
        problem4 = new Problem4();
        assertEquals("R olev blf", problem4.greenFlogRule("I love you"));
        assertEquals("Dlldz Xlfihv", problem4.greenFlogRule("Woowa Course"));
    }
}