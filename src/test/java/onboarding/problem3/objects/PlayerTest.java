package onboarding.problem3.objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("Player 가 숫자를 가지고 박수 친 횟수를 구한다.")
    void PlayerTest() {
        // given
        int number = 3;
        int expectedValue = 1;

        Player player = new Player(number);
        Rule rule = new Rule();

        // when
        int result = player.numberComeTrue(rule);

        // then
        assertThat(result).isEqualTo(expectedValue);
    }

}