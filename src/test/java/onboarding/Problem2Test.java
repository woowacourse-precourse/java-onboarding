package onboarding;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Problem2 Test")
class Problem2Test {

    @Test
    @DisplayName("[deduplication] 중복 제거 테스트")
    public void testDeduplication() {
        Problem2 problem2 = new Problem2();
        String cryptogram = problem2.deduplication("browoanoommnaon");
        assertEquals(cryptogram,"browoannaon");
    }



}