package onboarding.problem6.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class NicknameCheckerTest {

    private NicknameChecker nicknameChecker;

    @BeforeEach
    void setUp() {
        this.nicknameChecker = new NicknameChecker(List.of(List.of("test@email.com", "forTest")));
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
        assertThat(nicknameChecker.distinctSubString(text)).isEqualTo(expected);
    }
}
