package onboarding.domain;

import onboarding.domain.problem3.Clap;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Problem3Test {
    @Test
    public void clapNoCount() {
        assertThat(Clap.clap(214)).isEqualTo(0);
    }
    @Test
    public void clapOneCountTest() {
        assertThat(Clap.clap(13)).isEqualTo(1);
    }
    @Test
    public void clapTwoCountTest() {
        assertThat(Clap.clap(309)).isEqualTo(2);
    }
}
