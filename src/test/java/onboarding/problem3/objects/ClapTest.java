package onboarding.problem3.objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClapTest {

    @Test
    @DisplayName("3, 6, 9 게임 조건에 맞아 박수를 친 횟수를 구하는 테스트")
    void ClapTest() {
        // given
        int number = 33;
        int expectedValue = 2;

        Clap clap = new Clap(number);

        // when
        int result = clap.getClapCount();

        // then
        assertThat(result).isEqualTo(expectedValue);
    }

}