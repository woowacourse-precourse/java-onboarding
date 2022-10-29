package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @Test
    void gather() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

        List<String> result = Problem6.gather(forms);

        assertThat(result).containsExactly("jason@email.com", "jm@email.com", "mj@email.com");
    }

    @Test
    void exception() {
        List<List<String>> forms1 = Collections.emptyList();

        assertThatThrownBy(() -> Problem6.solution(forms1))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("크루는 1명 이상, 10,000 명 이하입니다.");

        List<List<String>> forms2 = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@naver.com", "워니"),
                List.of("mj@gmail.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

        assertThatThrownBy(() -> Problem6.solution(forms2))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("email.com 이메일만 사용할 수 있습니다.");

        List<List<String>> forms3 = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jasdddddssdddon@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

        assertThatThrownBy(() -> Problem6.solution(forms3))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("이메일 길이는 11자 이상 20자 미만입니다.");

        List<List<String>> forms4 = List.of(
                List.of("jm@email.com", "제이엠제이엠제이엠제이엠제이엠제이엠제이제미에에지에에"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

        assertThatThrownBy(() -> Problem6.solution(forms4))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("닉네임의 길이는 1자 이상 20자 미만입니다.");

        List<List<String>> forms5 = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "wooney"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

        assertThatThrownBy(() -> Problem6.solution(forms5))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("닉네임은 한글만 가능합니다.");
    }
}