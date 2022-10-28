package onboarding.problem3.objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RuleTest {

    @Test
    @DisplayName("3,6,9 룰에 맞아 박수 횟수를 반환한다.")
    void numberComeTrue() {
        // given
        int number = 66;
        int expectedValue = 2;

        Rule rule = new Rule();
        Clap clap = new Clap(number);

        // when
        int result = rule.numberComeTrue(clap);

        // then
        assertThat(result).isEqualTo(expectedValue);
    }

}