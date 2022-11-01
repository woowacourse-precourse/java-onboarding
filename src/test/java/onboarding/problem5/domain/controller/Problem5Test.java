package onboarding.problem5.domain.controller;

import onboarding.problem5.domain.Money;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem5Test {
    @Test
    void case1() {
        int money = 50_237;
        List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
        assertThat(new Money(money).numberOfEachCurrency()).isEqualTo(result);
    }
    
    @Test
    void case2() {
        int money = 15_000;
        List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
        assertThat(new Money(money).numberOfEachCurrency()).isEqualTo(result);
    }
    
    @Test
    void case3() {
        int money = 1;
        List<Integer> result = List.of(0, 0, 0, 0, 0, 0, 0, 0, 1);
        assertThat(new Money(money).numberOfEachCurrency()).isEqualTo(result);
    }
    
    @Test
    void case4() {
        int money = 1_000_000;
        List<Integer> result = List.of(20, 0, 0, 0, 0, 0, 0, 0, 0);
        assertThat(new Money(money).numberOfEachCurrency()).isEqualTo(result);
    }
    
    @Test
    void case5() {
        int money = 2;
        List<Integer> result = List.of(0, 0, 0, 0, 0, 0, 0, 0, 2);
        assertThat(new Money(money).numberOfEachCurrency()).isEqualTo(result);
    }
    
    @Test
    void case6() {
        int money = 999_999;
        List<Integer> result = List.of(19, 4, 1, 4, 1, 4, 1, 4, 9);
        assertThat(new Money(money).numberOfEachCurrency()).isEqualTo(result);
    }
    
    @Test
    void case7() {
        int money = 999_998;
        List<Integer> result = List.of(19, 4, 1, 4, 1, 4, 1, 4, 8);
        assertThat(new Money(money).numberOfEachCurrency()).isEqualTo(result);
    }
    
    @Test
    void case8() {
        int money = 990_998;
        List<Integer> result = List.of(19, 4, 0, 0, 1, 4, 1, 4, 8);
        assertThat(new Money(money).numberOfEachCurrency()).isEqualTo(result);
    }
    
    @Test
    void case9() {
        int money = 10;
        List<Integer> result = List.of(0, 0, 0, 0, 0, 0, 0, 1, 0);
        assertThat(new Money(money).numberOfEachCurrency()).isEqualTo(result);
    }
    
    @Test
    void case10() {
        int money = 50;
        List<Integer> result = List.of(0, 0, 0, 0, 0, 0, 1, 0, 0);
        assertThat(new Money(money).numberOfEachCurrency()).isEqualTo(result);
    }
    
    @Test
    void case11() {
        int money = 100;
        List<Integer> result = List.of(0, 0, 0, 0, 0, 1, 0, 0, 0);
        assertThat(new Money(money).numberOfEachCurrency()).isEqualTo(result);
    }
    
    @Test
    void case12() {
        int money = 500;
        List<Integer> result = List.of(0, 0, 0, 0, 1, 0, 0, 0, 0);
        assertThat(new Money(money).numberOfEachCurrency()).isEqualTo(result);
    }
    
    @Test
    void case13() {
        int money = 1000;
        List<Integer> result = List.of(0, 0, 0, 1, 0, 0, 0, 0, 0);
        assertThat(new Money(money).numberOfEachCurrency()).isEqualTo(result);
    }
    
    @Test
    void case14() {
        int money = 5000;
        List<Integer> result = List.of(0, 0, 1, 0, 0, 0, 0, 0, 0);
        assertThat(new Money(money).numberOfEachCurrency()).isEqualTo(result);
    }
    
    @Test
    void case15() {
        int money = 10000;
        List<Integer> result = List.of(0, 1, 0, 0, 0, 0, 0, 0, 0);
        assertThat(new Money(money).numberOfEachCurrency()).isEqualTo(result);
    }
    
    @Test
    void case16() {
        int money = 50000;
        List<Integer> result = List.of(1, 0, 0, 0, 0, 0, 0, 0, 0);
        assertThat(new Money(money).numberOfEachCurrency()).isEqualTo(result);
    }
    
    @Test
    void case17() {
        int money = 50049;
        List<Integer> result = List.of(1, 0, 0, 0, 0, 0, 0, 4, 9);
        assertThat(new Money(money).numberOfEachCurrency()).isEqualTo(result);
    }
    
    @Test
    void case18() {
        int money = 50061;
        List<Integer> result = List.of(1, 0, 0, 0, 0, 0, 1, 1, 1);
        assertThat(new Money(money).numberOfEachCurrency()).isEqualTo(result);
    }
}
