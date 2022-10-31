package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {

    @Test
    void count() {
        int[] priceList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        List<Integer> result = Problem5.count(priceList, 50237);

        assertThat(result).containsExactly(1, 0, 0, 0, 0, 2, 0, 3, 7);

    }

    @Test
    void exception() {
        int[] priceList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        assertThatThrownBy(() -> Problem5.solution(0))
                .isInstanceOf(RuntimeException.class);
    }
}