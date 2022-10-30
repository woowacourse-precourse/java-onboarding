package onboarding.problem6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NickNameTest {
    @Test
    void getNickName() {
        String testNickName = "엠제이";
        NickName result = new NickName("엠제이");
        assertThat(testNickName).isEqualTo(result.getNickName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"apple", "한글이야?", "1234", "#!#!#"})
    void if_not_korean_nick(String nickName) {
        assertThrows(NickNameException.class, () -> new NickName(nickName));
    }
    @ParameterizedTest
    @ValueSource(strings = {"", "한글이지만길이가너무길면굉장히곤란해요제발"})
    void if_not_MAX_and_MIN(String nickName) {
        assertThrows(NickNameException.class, () -> new NickName(nickName));
    }

}
