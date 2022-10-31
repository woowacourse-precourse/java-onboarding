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

    @Test
    void TestisLowerCase(){
        String T1 = "abcd";
        String T2 = "ABCD";
        String T3 = "Abcd";

        assertThat(Problem2.isLowerCase(T1)).isEqualTo(true);
        assertThat(Problem2.isLowerCase(T2)).isEqualTo(false);
        assertThat(Problem2.isLowerCase(T3)).isEqualTo(false);

    }
}
