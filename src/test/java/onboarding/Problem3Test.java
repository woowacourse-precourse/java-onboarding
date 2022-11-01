package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {
    Problem3 problem3;

    @Test
    @DisplayName("3,6,9가 포함되어 있는 수만큼 박수 세기")
    void countClap() {
        problem3 = new Problem3();
        assertEquals(3, problem3.countClap(666));
    }

}