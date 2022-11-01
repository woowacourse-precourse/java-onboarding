package onboarding.problem6;

import onboarding.Problem6;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailTest {
    @Test
    void case1() {
        Email email = new Email("jm@email.com");
        Email result = new Email("jm@email.com");
        assertThat(email).isEqualTo(result);
    }

    @Test
    void if_wrong_input(){
        assertAll(
                () -> assertThrows(EmailException.class, () -> new Email("jm@gmail.com")),
                () -> assertThrows(EmailException.class, () -> new Email("@email.com")),
                () -> assertThrows(EmailException.class, () -> new Email("lovvuuuffjm@email.com"))
        );
    }
}
