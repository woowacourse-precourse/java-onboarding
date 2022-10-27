package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("[Problem4] 기능 테스트")
class Problem4Test {

    private Problem4 problem4 = new Problem4();

    @Test
    @DisplayName("[Problem4][upperCaseDivisionTest] 대소문자 구분 테스트")
    public void upperCaseDivisionTest() {
        assertEquals(true,problem4.upperCaseDivision("A".charAt(0)));
    }

    @Test
    @DisplayName("[Problem][characterOneConversion] 문자 변환 테스트")
    public void characterOneConversionTest() {
        assertEquals("o".charAt(0),problem4.characterOneConversion("l".charAt(0),false));
    }

}