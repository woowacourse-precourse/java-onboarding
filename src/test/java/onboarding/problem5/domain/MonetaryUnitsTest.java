package onboarding.problem5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MonetaryUnitsTest {
    @Test
    @DisplayName("오만원 권 개수 구하기")
    void fiftyThousandDivide() {
        assertThat(MonetaryUnits.FIFTY_THOUSAND.divide(100001)).isEqualTo(2);
    }
    
    @Test
    @DisplayName("만원 권 개수 구하기")
    void tenThousandDivide() {
        assertThat(MonetaryUnits.TEN_THOUSAND.divide(40001)).isEqualTo(4);
    }
    
    @Test
    @DisplayName("오천원 권 개수 구하기")
    void fiveThousandDivide() {
        assertThat(MonetaryUnits.FIVE_THOUSAND.divide(9001)).isEqualTo(1);
    }
    
    @Test
    @DisplayName("천원 권 개수 구하기")
    void oneThousandDivide() {
        assertThat(MonetaryUnits.ONE_THOUSAND.divide(4001)).isEqualTo(4);
    }
    
    @Test
    @DisplayName("오백원 동전 개수 구하기")
    void fiveHundredDivide() {
        assertThat(MonetaryUnits.FIVE_HUNDRED.divide(901)).isEqualTo(1);
    }
    
    @Test
    @DisplayName("백원 동전 개수 구하기")
    void oneHundredDivide() {
        assertThat(MonetaryUnits.ONE_HUNDRED.divide(401)).isEqualTo(4);
    }
    
    @Test
    @DisplayName("오십원 동전 개수 구하기")
    void fiftyDivide() {
        assertThat(MonetaryUnits.FIFTY.divide(91)).isEqualTo(1);
    }
    
    @Test
    @DisplayName("십원 동전 개수 구하기")
    void tenDivide() {
        assertThat(MonetaryUnits.TEN.divide(41)).isEqualTo(4);
    }
    
    @Test
    @DisplayName("일원 동전 개수 구하기")
    void oneDivide() {
        assertThat(MonetaryUnits.ONE.divide(8)).isEqualTo(8);
    }
    
    @Test
    @DisplayName("오만원 권으로 나눈 나머지 구하기")
    void fiftyThousandRemainder() {
        assertThat(MonetaryUnits.FIFTY_THOUSAND.remainder(100001)).isEqualTo(1);
    }
    
    @Test
    @DisplayName("만원 권으로 나눈 나머지 구하기")
    void tenThousandRemainder() {
        assertThat(MonetaryUnits.TEN_THOUSAND.remainder(40001)).isEqualTo(1);
    }
    
    @Test
    @DisplayName("오천원 권으로 나눈 나머지 구하기")
    void fiveThousandRemainder() {
        assertThat(MonetaryUnits.FIVE_THOUSAND.remainder(9001)).isEqualTo(4001);
    }
    
    @Test
    @DisplayName("천원 권으로 나눈 나머지 구하기")
    void oneThousandRemainder() {
        assertThat(MonetaryUnits.ONE_THOUSAND.remainder(4001)).isEqualTo(1);
    }
    
    @Test
    @DisplayName("오백원으로 나눈 나머지 구하기")
    void fiveHundredRemainder() {
        assertThat(MonetaryUnits.FIVE_HUNDRED.remainder(901)).isEqualTo(401);
    }
    
    @Test
    @DisplayName("백원으로 나눈 나머지 구하기")
    void oneHundredRemainder() {
        assertThat(MonetaryUnits.ONE_HUNDRED.remainder(401)).isEqualTo(1);
    }
    
    @Test
    @DisplayName("오십원으로 나눈 나머지 구하기")
    void fiftyRemainder() {
        assertThat(MonetaryUnits.FIFTY.remainder(91)).isEqualTo(41);
    }
    
    @Test
    @DisplayName("십원으로 나눈 나머지 구하기")
    void tenRemainder() {
        assertThat(MonetaryUnits.TEN.remainder(41)).isEqualTo(1);
    }
}
