package onboarding.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CashMachineTest {
    @Test
    @DisplayName("잔액 교환 - 1,000,000원")
    void 잔액_교환_1000000원() {
        CashMachine cashMachine = new CashMachine(1000000);
        List<Integer> result = List.of(20, 0, 0, 0, 0, 0, 0, 0, 0);
        assertEquals(result, cashMachine.withdrawMoney());
    }

    @Test
    @DisplayName("잔액 교환 - 0원")
    void 잔액_교환_0원() {
        CashMachine cashMachine = new CashMachine(0);
        List<Integer> result = List.of(0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertEquals(result, cashMachine.withdrawMoney());
    }
}