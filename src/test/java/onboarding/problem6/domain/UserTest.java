package onboarding.problem6.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    @Test
    @DisplayName("서로의 객체가 같은지 확인")
    void isSameUser() {
        User sjh = new User("신준혁", "tjdtls690@email.com");
        assertThat(sjh).isEqualTo(new User("신준혁", "tjdtls690@email.com"));
    }
}
