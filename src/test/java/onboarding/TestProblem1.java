package onboarding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestProblem1 {

    @Test
    void TestsumDigit() {
        assertThat(Problem1.sumDigit(97)).isEqualTo(16);
        assertThat(Problem1.sumDigit(98)).isEqualTo(17);
        assertThat(Problem1.sumDigit(131)).isEqualTo(5);
        assertThat(Problem1.sumDigit(99)).isEqualTo(18);
        assertThat(Problem1.sumDigit(197)).isEqualTo(17);
    }

}
