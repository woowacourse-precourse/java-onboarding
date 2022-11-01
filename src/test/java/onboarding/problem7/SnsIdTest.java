package onboarding.problem7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SnsIdTest {
    @Test
    void if_wrong_input() {
        assertAll(() -> assertThrows(UserInputException.class, () -> new SnsId("fxemhfaduuajgtbpxlzznixnqtslnpm")),
                () -> assertThrows(UserInputException.class, () -> new SnsId("")),
                () -> assertThrows(UserInputException.class, () -> new SnsId("AZ")));
    }
}