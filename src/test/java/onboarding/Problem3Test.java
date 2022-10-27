package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("[Problem3] Test")
class Problem3Test {
    private Problem3 problem3 = new Problem3();

    @Test
    @DisplayName("[Problem3][getClapPerNumber]숫자 당 박수 테스트")
    public void getClapPerNumberTest() {
        assertEquals(0,problem3.getClapPerNumber(12));
    }

    @Test
    @DisplayName("[Problem3][getApplause]모든 박수 구하기 테스트")
    public void getApplauseTest() {
        assertEquals(14,problem3.getApplause(33));
    }

}