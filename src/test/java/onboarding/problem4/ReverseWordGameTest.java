package onboarding.problem4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReverseWordGameTest {
    @Test
    void if_under_MIN(){
        assertThrows(ReverseException.class, () -> ReverseWordGame.start(""));
    }
}
