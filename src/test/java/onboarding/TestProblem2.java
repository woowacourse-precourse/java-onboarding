package onboarding;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestProblem2 {

    @Test
    void TestisInRange(){
        String T1 = "abc";
        String T2 = "";
        String T3 = "werasd";

        assertThat(Problem2.isInRange(T1)).isEqualTo(true);
        assertThat(Problem2.isInRange(T2)).isEqualTo(false);
        assertThat(Problem2.isInRange(T3)).isEqualTo(true);
    }
}
