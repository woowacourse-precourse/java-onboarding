package problem3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreeSixNineGameTest {

    @Test
    void 숫자가_주어질때_369의개수_카운트() {
        int count1 = ThreeSixNineGame.isThreeSixNineNumber(153);
        int count2 = ThreeSixNineGame.isThreeSixNineNumber(133);
        int count3 = ThreeSixNineGame.isThreeSixNineNumber(100);

        assertThat(count1).isEqualTo(1);
        assertThat(count2).isEqualTo(2);
        assertThat(count3).isEqualTo(0);
    }
}