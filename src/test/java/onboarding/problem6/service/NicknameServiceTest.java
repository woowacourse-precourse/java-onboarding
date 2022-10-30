package onboarding.problem6.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

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

    private static Stream<Arguments> provideForTextDistinctSubString() {
        return Stream.of(
                Arguments.of("한", List.of()),
                Arguments.of("포비", List.of("포비")),
                Arguments.of("제이엠", List.of("제이", "이엠")),
                Arguments.of("제이제이", List.of("제이", "이제"))
        );
    }

    @ParameterizedTest(name = "문자열의 길이가 2 이상이고 두 글자씩 나누고 중복된 문자열을 제거한 후 리스트를 반환한다." +
            "만약 문자열의 길이가 1이라면 빈 리스트를 반환한다.")
    @MethodSource("provideForTextDistinctSubString")
    void distinct_subString(String text, List<String> expected) {
        assertThat(NicknameService.distinctSubString(text)).isEqualTo(expected);
    }

}
