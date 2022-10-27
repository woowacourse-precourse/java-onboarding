package onboarding.problem1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    @DisplayName("각 플레이어의 가장 큰 수 구하기")
    void getMaxNumber() {
        Player player = new Player(113, 115);
        assertThat(player.getMaxNumber()).isEqualTo(7);
    }
}
