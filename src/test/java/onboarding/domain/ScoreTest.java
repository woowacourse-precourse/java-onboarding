package onboarding.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    @DisplayName("에러 - 연속되지 않은 페이지 번호")
    void 연속되지_않은_페이지_번호() {
        assertThrows(IllegalArgumentException.class,
                () -> new Score(List.of(123, 125)));
    }

    @Test
    @DisplayName("에러 - 경계값을 포함하는 페이지 번호")
    void 경계값을_포함하는_페이지_번호() {
        assertThrows(IllegalArgumentException.class,
                () -> new Score(List.of(1, 2)));
    }

    @Test
    @DisplayName("승리")
    void 승리() {
        Score user = new Score(List.of(297, 298));
        Score anotherPlayer = new Score(List.of(197, 198));
        int result = 1;
        assertEquals(result, user.playGame(anotherPlayer));
    }

    @Test
    @DisplayName("패배")
    void 패배() {
        Score user = new Score(List.of(197, 198));
        Score anotherPlayer = new Score(List.of(297, 298));
        int result = 2;
        assertEquals(result, user.playGame(anotherPlayer));
    }

    @Test
    @DisplayName("무승부")
    void 무승부() {
        Score user = new Score(List.of(197, 198));
        Score anotherPlayer = new Score(List.of(197, 198));
        int result = 0;
        assertEquals(result, user.playGame(anotherPlayer));
    }
}