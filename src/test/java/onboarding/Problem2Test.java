package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Problem2 Test")
class Problem2Test {

    @Test
    public void testDeduplication() {
        Problem2 problem2 = new Problem2();
        String cryptogram = problem2.deduplication("browoanoommnaon");
        assertEquals(cryptogram,"browoannaon");
    }





}