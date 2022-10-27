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

}