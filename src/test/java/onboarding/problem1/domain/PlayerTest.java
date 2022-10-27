package onboarding.problem1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    @DisplayName("leftPlayer win")
    void leftWin() {
        Player player = new Player(239, 240);
        assertThat(player.compareTo(new Player(237, 238))).isEqualTo(1);
    }
    
    @Test
    @DisplayName("rightPlayer win")
    void rightWin() {
        Player player = new Player(237, 238);
        assertThat(player.compareTo(new Player(239, 240))).isEqualTo(2);
    }
    
    @Test
    @DisplayName("draw")
    void draw() {
        Player player = new Player(157, 158);
        assertThat(player.compareTo(new Player(57, 58))).isEqualTo(0);
    }
}
