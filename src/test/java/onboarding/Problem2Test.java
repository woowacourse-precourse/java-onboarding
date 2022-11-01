package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    Problem2 problem2;

    @Test
    @DisplayName("중복 제거 테스트")
    void removeDuplicate() {
        problem2 = new Problem2();
        assertEquals("browoannaoi", problem2.removeDuplicate("browoanoommnaonnni"));
    }

}