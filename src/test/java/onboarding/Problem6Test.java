package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem6Test {
    @Test
    void extraCase1() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("mwon@email.com", "엠워니")
        );
        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com", "mwon@email.com", "woniee@email.com");
        assertThat(Problem6.solution(forms)).isEqualTo(result);
    }
}