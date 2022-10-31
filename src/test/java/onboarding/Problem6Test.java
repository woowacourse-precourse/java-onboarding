package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문제 6 테스트")
class Problem6Test {
    @DisplayName("신청받은 닉네임 중 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 return 한다.")
    @Test
    void solution() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이"),
                List.of("mj@email.com", "제이"),
                List.of("woniee@email.com", "제"),
                List.of("jason@email.com", "제이")
        );

        List<String> result = Problem6.solution(forms);

        assertThat(result).containsExactly("jason@email.com", "jm@email.com", "mj@email.com");
    }
}
