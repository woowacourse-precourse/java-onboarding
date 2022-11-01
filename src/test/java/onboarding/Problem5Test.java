package onboarding;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@Disabled
@DisplayName("[Problem5] 테스트")
class Problem5Test {

    @Test
    @DisplayName("[Problem5][exchangeMoney] 화폐 갯수 구하기 테스트")
    public void exchangeMoneyTest() {
        assertEquals(100,Problem5.exchangeMoney(100,10001));
    }

    @Test
    @DisplayName("[Problem5][exchangeAllMoney] 화폐 갯수 구하기 테스트")
    public void exchangeAllMoneyTest() {
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(1,0,0,0,0,2,0,3,7));
        assertEquals(result,Problem5.exchangeAllMoney(50237));
    }

}
