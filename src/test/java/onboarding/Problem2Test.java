package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    void deduplicate() {
        String result = Problem2.deduplicate("brooorwnnk");

        assertThat(result).isEqualTo("brrwk");
    }

    @Test
    void decode() {
        String result = Problem2.decode("brooorwnnk");

        assertThat(result).isEqualTo("bwk");
    }

    @Test
    void exception() {
        assertThatThrownBy(() -> Problem2.solution(""))
                .isInstanceOf(RuntimeException.class);

    }
}