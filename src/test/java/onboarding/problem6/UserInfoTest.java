package onboarding.problem6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("이메일, 닉네임쌍 검증 단계")
public class UserInfoTest {
    @DisplayName("잘 작동함")
    @Test
    void 잘_작동() {
        assertThat(new UserInfo(List.of("right@email.com", "한글닉")).isValid()).isEqualTo(true);
    }

    @DisplayName("전체가 null인 경우")
    @Test
    void 전체_null() {
        assertThat(new UserInfo(null).isValid()).isEqualTo(false);
    }

    @DisplayName("이메일이 null인 경우")
    @Test
    void 이메일_null() {
        List<String> 이메일_없음 = new ArrayList<>();
        이메일_없음.add(null);
        이메일_없음.add("닉네임");
        assertThat(new UserInfo(이메일_없음).isValid()).isEqualTo(false);
    }

    @DisplayName("닉네임이 null인 경우")
    @Test
    void 닉네임_null() {
        List<String> 닉네임_없음 = new ArrayList<>();
        닉네임_없음.add("hello@email.com");
        닉네임_없음.add(null);
        assertThat(new UserInfo(닉네임_없음).isValid()).isEqualTo(false);
    }

    @DisplayName("이메일 길이 범위 바깥")
    @Test
    void 이메일_범위() {
        assertThat(new UserInfo(List.of("email.com", "한글")).isValid()).isEqualTo(false);
        assertThat(new UserInfo(List.of("email.comemail.comemail.com", "한글")).isValid()).isEqualTo(false);
    }

    @DisplayName("이메일 끝이 email.com이 아님")
    @Test
    void 이메일_도메인() {
        assertThat(new UserInfo(List.of("hello@mgmail.com", "한글")).isValid()).isEqualTo(false);
    }

    @DisplayName("이름이 한글이 아닌 글자가 있음")
    @Test
    void 닉네임_한글_아님() {
        assertThat(new UserInfo(List.of("right@email.com", "한글s")).isValid()).isEqualTo(false);
    }

    @DisplayName("이름 범위 바깥")
    @Test
    void 닉네임_범위() {
        assertThat(new UserInfo(List.of("right@email.com", "")).isValid()).isEqualTo(false);
    }
}
