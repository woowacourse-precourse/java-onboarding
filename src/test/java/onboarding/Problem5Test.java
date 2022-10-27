package onboarding;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("[Problem5] 테스트")
class Problem5Test {

    @Test
    @DisplayName("[Problem5][exchangeMoney] 화폐 갯수 구하기 테스트")
    public void exchangeMoneyTest() {
        assertEquals(100,Problem5.exchangeMoney(100,10001));
    }

}
