package onboarding.problem7;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void createUser() {
        User user = new User("abc");
        Assertions.assertThat(user).isEqualTo(new User("abc"));
    }
}
