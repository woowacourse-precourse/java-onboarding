package onboarding.problem6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NickNameTest {
    @Test
    void getNickName() {
        String testNickName = "이제엠";
        NickName result = new NickName("이제엠");
        assertThat(testNickName).isEqualTo(result.getNickName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"apple", "한글이야?", "1234", "#!#!#"})
    void if_not_korean_nick(String nickName) {
        assertThrows(NickNameException.class, () -> new NickName(nickName));
    }
}
