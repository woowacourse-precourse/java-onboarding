package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("크루 단위테스트")
class CrewTest {
    @DisplayName("크루들의 닉네임 중 같은 글자가 연속적으로 포함 될 경우 true를 반환한다.")
    @Test
    void duplicate() {
        Crew jason = new Crew("json@email.com", "제이슨");
        Crew mj = new Crew("mj@email.com", "엠제이");

        boolean result = jason.duplicate(mj);

        assertThat(result).isTrue();
    }

    @DisplayName("크루들의 닉네임 중 같은 글자가 연속적으로 포함되지 않은 경우 false를 반환한다.")
    @Test
    void notDuplicate() {
        Crew jason = new Crew("json@email.com", "제이슨");
        Crew woniee = new Crew("mj@email.com", "워니");

        boolean result = jason.duplicate(woniee);

        assertThat(result).isFalse();
    }

    @DisplayName("두 크루의 닉네임이 두 글자이고 일치하는 경우 true를 반환한다.")
    @Test
    void towLetters() {
        Crew jason = new Crew("json@email.com", "제이");
        Crew mj = new Crew("mj@email.com", "제이");

        boolean result = jason.duplicate(mj);

        assertThat(result).isTrue();
    }

    @DisplayName("두 크루의 닉네임이 한 글자면 일치하더라도 false를 반환한다..")
    @Test
    void oneLetter() {
        Crew jason = new Crew("json@email.com", "제");
        Crew mj = new Crew("mj@email.com", "제");

        boolean result = jason.duplicate(mj);

        assertThat(result).isFalse();
    }
}
