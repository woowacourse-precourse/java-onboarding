package onboarding.problem1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PlayerTest {
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
        assertThat(player.compareTo(new Player(57, 58))).isZero();
    }
    
    @Test
    @DisplayName("짝수 홀수가 안맞는 경우")
    void isNotCorrectEvenAndOddNumbers() {
        assertAll(
                () -> assertThat(new Player(158, 159).compareTo(new Player(57, 58))).isEqualTo(-1),
                () -> assertThat(new Player(157, 158).compareTo(new Player(58, 59))).isEqualTo(-1)
        );
    }
    
    @Test
    @DisplayName("차이가 1이 아닌 경우")
    void isDifferenceNotOne() {
        assertAll(
                () -> assertThat(new Player(157, 160).compareTo(new Player(57, 58))).isEqualTo(-1),
                () -> assertThat(new Player(157, 158).compareTo(new Player(57, 59))).isEqualTo(-1)
        );
    }
    
    @Test
    @DisplayName("왼쪽 수가 오른쪽 수보다 더 큰 경우")
    void isLeftBigger() {
        assertAll(
                () -> assertThat(new Player(161, 160).compareTo(new Player(57, 58))).isEqualTo(-1),
                () -> assertThat(new Player(157, 158).compareTo(new Player(59, 58))).isEqualTo(-1)
        );
    }
}
