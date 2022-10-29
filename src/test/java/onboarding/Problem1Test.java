package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @Test
    void findMaxScore() {
        List<Integer> pobi = List.of(97, 98);
        int maxScore = Problem1.findMaxScore(pobi);
        assertThat(maxScore).isEqualTo(72);
    }

    @Test
    void validation() {
        List<Integer> pobi1 = List.of(97, 98);
        int maxScore = Problem1.findMaxScore(pobi1);
        assertThat(maxScore).isEqualTo(72);

        List<Integer> pobi2 = List.of(97, 103);
        int errorScore1 = Problem1.findMaxScore(pobi2);
        assertThat(errorScore1).isEqualTo(-1);

        List<Integer> pobi3 = List.of(0, 1);
        int errorScore2 = Problem1.findMaxScore(pobi3);
        assertThat(errorScore2).isEqualTo(-1);

        List<Integer> pobi4 = List.of(400, 401);
        int errorScore3 = Problem1.findMaxScore(pobi4);
        assertThat(errorScore3).isEqualTo(-1);
    }

    @Test
    void excecption() {
        List<Integer> pobi = List.of(97, 98, 99);
        int result = Problem1.findMaxScore(pobi);
        assertThat(result).isEqualTo(-1);
    }
}