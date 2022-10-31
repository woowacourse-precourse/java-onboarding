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

    @Test
    void TestisException(){
        String T1 = "abcd";
        String T2 = "ABCD";
        String T3 = "Abcd";
        String T4 = "";

        assertThat(Problem2.isException(T1)).isEqualTo(true);
        assertThat(Problem2.isException(T2)).isEqualTo(false);
        assertThat(Problem2.isException(T3)).isEqualTo(false);
        assertThat(Problem2.isException(T4)).isEqualTo(false);
    }

    @Test
    void TsetdeleteDuplicate(){
        assertThat(Problem2.deleteDuplicate("abcdee", 4, 5)).isEqualTo("abcd");

    }

    @Test
    void TestfindDuplicate(){
        assertThat(Problem2.findDuplicate("abcdee")).isEqualTo("abcd");
        assertThat(Problem2.findDuplicate("aacdef")).isEqualTo("cdef");
        assertThat(Problem2.findDuplicate("aaaef")).isEqualTo("ef");
    }
}
