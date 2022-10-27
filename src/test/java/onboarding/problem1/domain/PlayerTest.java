package onboarding.problem1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    @DisplayName("가장 큰 더하기 숫자 구하기")
    void getMaxSum() {
        Player player = new Player(237, 238);
        assertThat(player.getMaxSum()).isEqualTo(13);
    }
    
    @Test
    @DisplayName("가장 큰 곱하기 숫자 구하기")
    void getMaxMultiply() {
        Player player = new Player(237, 238);
        assertThat(player.getMaxMultiply()).isEqualTo(48);
    }
}
