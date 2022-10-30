package onboarding;

import org.junit.jupiter.api.Test;

import javax.swing.table.TableCellRenderer;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestProblem1 {

    @Test
    void TestsumDigit() {
        assertThat(Problem1.sumDigit(97)).isEqualTo(16);
        assertThat(Problem1.sumDigit(98)).isEqualTo(17);
        assertThat(Problem1.sumDigit(131)).isEqualTo(5);
        assertThat(Problem1.sumDigit(99)).isEqualTo(18);
        assertThat(Problem1.sumDigit(197)).isEqualTo(17);
    }

    @Test
    void TestmultiplyDigit(){
        assertThat(Problem1.multiplyDigit(97)).isEqualTo(63);
        assertThat(Problem1.multiplyDigit(98)).isEqualTo(72);
        assertThat(Problem1.multiplyDigit(131)).isEqualTo(3);
        assertThat(Problem1.multiplyDigit(132)).isEqualTo(6);
        assertThat(Problem1.multiplyDigit(198)).isEqualTo(72);
    }

    @Test
    void TestisInRange(){
        List<Integer> T1 = List.of(97, 98);
        List<Integer> T2 = List.of(1, 98);
        List<Integer> T3 = List.of(97, 400);
        List<Integer> T4 = List.of(0, 0);
        assertThat(Problem1.isInRange(T1)).isEqualTo(true);
        assertThat(Problem1.isInRange(T2)).isEqualTo(false);
        assertThat(Problem1.isInRange(T3)).isEqualTo(false);
        assertThat(Problem1.isInRange(T4)).isEqualTo(false);
    }

    @Test
    void TestisOdd(){
        assertThat(Problem1.isOdd(100)).isEqualTo(false);
        assertThat(Problem1.isOdd(99)).isEqualTo(true);
    }

    @Test
    void TestisEven(){
        assertThat(Problem1.isEven(100)).isEqualTo(true);
        assertThat(Problem1.isEven(99)).isEqualTo(false);
    }
}
