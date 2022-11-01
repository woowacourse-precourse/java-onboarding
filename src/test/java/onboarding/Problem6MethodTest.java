package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

import static onboarding.Problem6.getSubstrFromNickname;
import static org.assertj.core.api.Assertions.assertThat;

class Problem6MethodTest {

    @Test
    void getSubstrFromNicknameTest() {
        String nickname1 = "제이엠";
        String nickname2 = "제이슨";

        List<String> result1 = getSubstrFromNickname(nickname1);
        List<String> result2 = getSubstrFromNickname(nickname2);

        assertThat(result1).isEqualTo(List.of("제이", "이엠"));
        assertThat(result2).isEqualTo(List.of("제이", "이슨"));
    }
}