package onboarding;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@Disabled
@DisplayName("Problem2 Test")
class Problem2Test {

    private Problem2 problem2 = new Problem2();

    @Test
    @DisplayName("[deduplication] 중복 제거 테스트")
    public void testDeduplication() {
        String cryptogram = problem2.deduplication("browoanoommnaon");
        assertEquals(cryptogram,"browoannaon");
    }

    @Test
    @DisplayName("[endPoint] 종료 확인 테스트")
    public void testEndPoint() {
        assertEquals(true,problem2.endPoint("abcd"));
    }

    @Test
    @DisplayName("[solution] 솔루션 함수 작동 테스트")
    public void testSolution() {
        assertEquals("brown",problem2.solution("browoanoommnaon"));
    }

}