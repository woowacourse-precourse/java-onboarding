package problem3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreeSixNineGameTest {

    @Test
    void 숫자가_주어질때_369의개수_카운트() {
        int count1 = ThreeSixNineGame.countThreeSixNine(153);
        int count2 = ThreeSixNineGame.countThreeSixNine(133);
        int count3 = ThreeSixNineGame.countThreeSixNine(100);

        assertThat(count1).isEqualTo(1);
        assertThat(count2).isEqualTo(2);
        assertThat(count3).isEqualTo(0);
    }

    @Test
    void 숫자가_주어질때_1부터_369의총개수_카운트() {
        int result1 = ThreeSixNineGame.playGame(13);
        int result2 = ThreeSixNineGame.playGame(33);

        assertThat(result1).isEqualTo(4);
        assertThat(result2).isEqualTo(14);
    }
}