package onboarding.myTest;

import onboarding.Problem6;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem6Test {


    @Test
    void case1() {
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
    void case2() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠")
        );
        List<String> result = List.of();
        assertThat(Problem6.solution(forms)).isEqualTo(result);
    }

    /**
     * 중복이 있는 경우 경우
     */
    @Test
    void case3() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
        assertThat(Problem6.solution(forms)).isEqualTo(result);
    }

    //"원피스", "제이슨", "원피수", "엠제이", "수원피"
    @Test
    void case4() {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "원피스"),
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "원피수"),
                List.of("woniee@email.com", "수원피"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com",  "woniee@email.com");
        assertThat(Problem6.solution(forms)).isEqualTo(result);
    }


}
