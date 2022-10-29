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

    @Test
    void TestmultiplyDigit(){
        assertThat(Problem1.multiplyDigit(97)).isEqualTo(63);
        assertThat(Problem1.multiplyDigit(98)).isEqualTo(72);
        assertThat(Problem1.multiplyDigit(131)).isEqualTo(3);
        assertThat(Problem1.multiplyDigit(132)).isEqualTo(6);
        assertThat(Problem1.multiplyDigit(198)).isEqualTo(72);
    }

}
