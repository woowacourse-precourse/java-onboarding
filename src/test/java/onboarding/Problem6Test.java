package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem6Test {

    @Test
    void check() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

        boolean result1 = Problem6.check(forms, 0);
        boolean result2 = Problem6.check(forms, 1);
        boolean result3 = Problem6.check(forms, 2);
        boolean result4 = Problem6.check(forms, 3);

        assertThat(result1).isTrue();
        assertThat(result2).isTrue();
        assertThat(result3).isFalse();
        assertThat(result4).isTrue();
    }
}