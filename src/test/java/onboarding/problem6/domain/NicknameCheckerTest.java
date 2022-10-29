package onboarding.problem6.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class NicknameCheckerTest {

    private NicknameChecker nicknameChecker;

    @BeforeEach
    void setUp() {
        this.nicknameChecker = new NicknameChecker();
    }

    @DisplayName("문자열을 키로 값 1을 저장한다. 만약 이미 존재하는 문자열이라면 값을 1 증가시킨다.")
    @Test
    void save_nickname_after_check_duplicate() {
        String nickname = "제이제이";
        nicknameChecker.saveNickname(nickname);
        assertThat(nicknameChecker.isDuplicate("제이")).isFalse();
        assertThat(nicknameChecker.isDuplicate("이제")).isFalse();
        nicknameChecker.saveNickname(nickname);
        assertThat(nicknameChecker.isDuplicate("제이")).isTrue();
        assertThat(nicknameChecker.isDuplicate("이제")).isTrue();
    }
}
