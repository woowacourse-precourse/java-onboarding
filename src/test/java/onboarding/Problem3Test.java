package onboarding;

import org.junit.jupiter.api.Test;
import utils.Problem3Util;

import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {
    @Test
    void validTest() {
        assertThat(Problem3Util.validCnt(13)).isEqualTo(1);
        assertThat(Problem3Util.validCnt(63)).isEqualTo(2);
        assertThat(Problem3Util.validCnt(19)).isEqualTo(1);
        assertThat(Problem3Util.validCnt(76)).isEqualTo(1);
        assertThat(Problem3Util.validCnt(11)).isEqualTo(0);
        assertThat(Problem3Util.validCnt(27)).isEqualTo(0);
    }

    @Test
    void clapCntTest() {
        assertThat(Problem3Util.getResult(13)).isEqualTo(4);
        assertThat(Problem3Util.getResult(33)).isEqualTo(14);
    }
}