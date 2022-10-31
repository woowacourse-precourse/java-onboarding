package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestProblem3 {
    @Test
    void TestisInRange(){
        assertThat(Problem3.isInRange(0)).isEqualTo(false);
        assertThat(Problem3.isInRange(10001)).isEqualTo(false);
        assertThat(Problem3.isInRange(9999)).isEqualTo(true);
    }

    @Test
    void TestMakeList(){
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        assertThat(Problem3.makeList(5)).isEqualTo(list);
    }

    @Test
    void TestdivideDigit(){
        List<Integer> T1 = List.of(3,3);
        List<Integer> T2 = List.of(3,3,1,9);
        List<Integer> T3 = List.of(0,1);

        assertThat(Problem3.divideDigit(33)).isEqualTo(T1);
        assertThat(Problem3.divideDigit(9133)).isEqualTo(T2);
        assertThat(Problem3.divideDigit(10)).isEqualTo(T3);
    }

    @Test
    void TestCount369(){
        assertThat(Problem3.Count369(13)).isEqualTo(4);
        assertThat(Problem3.Count369(33)).isEqualTo(14);
        assertThat(Problem3.Count369(2)).isEqualTo(0);
        assertThat(Problem3.Count369(10)).isEqualTo(3);
        assertThat(Problem3.Count369(3)).isEqualTo(3);

    }
}
