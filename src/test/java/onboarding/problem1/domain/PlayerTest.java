package onboarding.problem1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    @DisplayName("플레이어의 가장 큰 더하기 숫자 구하기")
    void getMaxSumOfPlayer() {
        Player player = new Player(237, 238);
        assertThat(player.getMaxSumOfPlayer()).isEqualTo(13);
    }
}
