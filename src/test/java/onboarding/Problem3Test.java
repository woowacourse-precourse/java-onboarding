package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {

    @Test
    void clap() {
        int result = Problem3.clap(98935);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void exception() {

        assertThatThrownBy(() -> Problem3.solution(10001))
                .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> Problem3.solution(-3))
                .isInstanceOf(RuntimeException.class);
    }
}