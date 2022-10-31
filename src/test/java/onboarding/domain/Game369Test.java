package onboarding.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Game369Test {
    @Test
    @DisplayName("경계값 테스트 - 1")
    void 경계값_테스트_1() {
        Game369 game369 = new Game369(1);
        assertEquals(0, game369.getGameResult());
    }

    @Test
    @DisplayName("경계값 테스트 - 10000")
    void 경계값_테스트_10000() {
        Game369 game369 = new Game369(10000);
        assertEquals(12000, game369.getGameResult());
    }
}