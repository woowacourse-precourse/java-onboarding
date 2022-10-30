package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("문제6번: 중복 닉네임 통보")
public class Problem6Test {
    @Test
    @DisplayName("정상적으로 작동한다.")
    void normalCase() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
        assertThat(Problem6.solution(forms)).isEqualTo(result);
    }

    @Test
    @DisplayName("이메일이 동일한 교육생이 있지만, 정상작동한다.")
    void duplicatedEmail() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("munj@email.com", "문제이"),
                List.of("munj@email.com", "먼제이")
        );
        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
        assertThat(Problem6.solution(forms)).isEqualTo(result);
    }

    @Test
    @DisplayName("닉네임이 완전히 동일한 교육생이 있지만, 정상작동한다.")
    void duplicatedNickname() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "엠제이")
        );
        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com", "nowm@email.com");
        assertThat(Problem6.solution(forms)).isEqualTo(result);
    }

    @Test
    @DisplayName("이메일과 닉네임이 동일한 교육생이 있지만, 정상작동한다.")
    void duplicatedEmailAndNickname() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("munk@email.com", "먼케이"),
                List.of("munk@email.com", "먼케이"),
                List.of("nowm@email.com", "이제엠")
        );
        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com", "munk@email.com");
        assertThat(Problem6.solution(forms)).isEqualTo(result);
    }
}
