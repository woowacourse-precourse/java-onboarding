package onboarding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {
    @Test
    void validNumTest() {
        assertThat(Problem3.validCnt(13)).isEqualTo(1);
        assertThat(Problem3.validCnt(63)).isEqualTo(2);
        assertThat(Problem3.validCnt(19)).isEqualTo(1);
        assertThat(Problem3.validCnt(76)).isEqualTo(1);
        assertThat(Problem3.validCnt(11)).isEqualTo(0);
        assertThat(Problem3.validCnt(27)).isEqualTo(0);
    }

    @Test
    void clapCntTest() {
        assertThat(Problem3.getResult(13)).isEqualTo(4);
        assertThat(Problem3.getResult(33)).isEqualTo(14);
    }
}