package onboarding.problem1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @Test
    @DisplayName("leftPlayer win")
    void leftWin() {
        Players players = new Players(Arrays.asList(239, 240), Arrays.asList(237, 238));
        assertThat(players.playResult()).isEqualTo(1);
    }
    
    @Test
    @DisplayName("rightPlayer win")
    void rightWin() {
        Players players = new Players(Arrays.asList(237, 238), Arrays.asList(239, 240));
        assertThat(players.playResult()).isEqualTo(2);
    }
}
