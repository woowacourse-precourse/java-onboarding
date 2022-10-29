package onboarding;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("[Problem6] Test")
@Disabled
class Problem6Test {

    @Test
    @DisplayName("[Problem6] solution Test")
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
    @DisplayName("[Problem6] 시간 복잡도 테스트")
    void case2() {
        List<List<String>> forms = new ArrayList<>();
        for (int i=0;i<10000;i++) {
            forms.add(new ArrayList<>(Arrays.asList("abc@naver.com","가가가가가나나나나나다다다다다라라라라")));
        }
        List<String> result = List.of("abc@naver.com");
        assertThat(Problem6.solution(forms)).isEqualTo(result);
    }

}