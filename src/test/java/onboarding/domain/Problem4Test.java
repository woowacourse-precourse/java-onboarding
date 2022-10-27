package onboarding.domain;

import onboarding.domain.problem4.Frog;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Problem4Test {
    @Test
    public void changeUpperTest() {
        Frog frog = new Frog();
        assertThat(frog.change('A')).isEqualTo('Z');
    }
    @Test
    public void changeLowerTest() {
        Frog frog = new Frog();
        assertThat(frog.change('z')).isEqualTo('a');
    }
}
