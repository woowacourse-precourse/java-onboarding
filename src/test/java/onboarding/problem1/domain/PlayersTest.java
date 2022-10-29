package onboarding.problem1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PlayersTest {
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
    
    @Test
    @DisplayName("draw")
    void draw() {
        Players players = new Players(Arrays.asList(157, 158), Arrays.asList(57, 58));
        assertThat(players.playResult()).isZero();
    }
    
    @Test
    @DisplayName("짝수 홀수가 안맞는 경우")
    void isNotCorrectEvenAndOddNumbers() {
        assertAll(
                () -> assertThat(new Players(Arrays.asList(158, 159), Arrays.asList(57, 58)).playResult()).isEqualTo(-1),
                () -> assertThat(new Players(Arrays.asList(157, 158), Arrays.asList(58, 59)).playResult()).isEqualTo(-1)
        );
    }
    
    @Test
    @DisplayName("차이가 1이 아닌 경우")
    void isDifferenceNotOne() {
        assertAll(
                () -> assertThat(new Players(Arrays.asList(157, 160), Arrays.asList(57, 58)).playResult()).isEqualTo(-1),
                () -> assertThat(new Players(Arrays.asList(157, 158), Arrays.asList(57, 59)).playResult()).isEqualTo(-1)
        );
    }
    
    @Test
    @DisplayName("왼쪽 수가 오른쪽 수보다 더 큰 경우")
    void isLeftBigger() {
        assertAll(
                () -> assertThat(new Players(Arrays.asList(161, 160), Arrays.asList(57, 58)).playResult()).isEqualTo(-1),
                () -> assertThat(new Players(Arrays.asList(157, 158), Arrays.asList(59, 58)).playResult()).isEqualTo(-1)
        );
    }
}
