package onboarding.problem6.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NicknameServiceTest {

    @DisplayName("닉네임 중 같은 글자가 연속적으로 포함되는 닉네임을 작성한 지원자의 이메일 목록을 반환한다.")
    @Test
    public void duplicateUserEmail() {
        List<List<String>> applyList = List.of(
                List.of("cho@email.com", "조"),
                List.of("joe@email.com", "조"),
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

        assertThat(NicknameService.duplicateNicknameEmail(applyList))
                .isEqualTo(List.of("jason@email.com", "jm@email.com", "mj@email.com"));
    }
}
