package onboarding.problem3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplauseParameterTest {
    @Test
    void if_Under_Min() {
        assertThrows(ApplauseException.class, () -> new ApplauseParameter(0));
    }

    @Test
    void if_Over_MAX() {
        assertThrows(ApplauseException.class, () -> new ApplauseParameter(10_001));
    }
}