package onboarding.problem7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    @Test
    void if_wrong_input() {
        assertAll( () -> assertThrows(UserInputException.class, () -> new SNSId("fxemhfaduuajgtbpxlzznixnqtslnpmrlmhagukw")),
                () -> assertThrows(UserInputException.class, () -> new SNSId(""))
                );
    }
}