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

    @Test
    void TestisAlreadyExist(){
        Set<String> T1 = new HashSet<>();
        T1.add("제이");
        T1.add("이엠");

        Set<String> T2 = new HashSet<>();
        T2.add("제이");
        T2.add("이엠");

        Set<String> T3 = new HashSet<>();
        T3.add("이제");
        T3.add("제엠");

        assertThat(Problem6.isAlreadyExist(T1, T2)).isEqualTo(true);
        assertThat(Problem6.isAlreadyExist(T1, T3)).isEqualTo(false);


    }
}
