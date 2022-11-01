package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {
    final int[] moneyUnits = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    int money = 0;
    Problem5 problem5;

    @Test
    @DisplayName("각 화폐단위에 맞는 돈의 개수와 거스름돈이 잘 구해지는지 확인")
    void getCountAndExamineMoney() {
        problem5 = new Problem5();
        money = 50237;

        for (int i=0; i<moneyUnits.length; i++) {
            assertEquals(money/moneyUnits[i], problem5.getMoneyCount(money, moneyUnits[i]));
            assertEquals(money%moneyUnits[i], problem5.examineChange(money, moneyUnits[i]));
        }
    }
    

}