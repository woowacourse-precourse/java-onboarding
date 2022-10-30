package onboarding.problem6;

import onboarding.Problem6;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NickNameTest {
    @Test
    void case1() {
        String testNickName = "이제엠";
        NickName result = new NickName("이제엠");
        assertThat(testNickName).isEqualTo(result.getNickName());
    }
}
