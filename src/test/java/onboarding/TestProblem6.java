package onboarding;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;


public class TestProblem6 {

    @Test
    void TestsliceName(){
        Set<String> T1 = new HashSet<>();
        T1.add("제이");
        T1.add("이엠");

        assertThat(Problem6.sliceName("제이엠")).isEqualTo(T1);
    }
}
