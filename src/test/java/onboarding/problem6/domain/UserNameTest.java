package onboarding.problem6.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserNameTest {
    @Test
    @DisplayName("유저 이름을 2글자씩 끊어서 객체 리스트 반환")
    void twoLetterNames() {
        UserName userName = new UserName("가나다라마바사");
        final List<UserName> expected = Arrays.asList(
                new UserName("가나"),
                new UserName("나다"),
                new UserName("다라"),
                new UserName("라마"),
                new UserName("마바"),
                new UserName("바사")
        );
        
        assertThat(userName.twoLetterNames()).isEqualTo(expected);
    }
}