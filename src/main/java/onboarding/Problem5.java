package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    enum Bill {
        FIFTY_THOUSAND(50000),
        TEN_THOUSAND(10000),
        FIVE_THOUSAND(5000),
        ONE_THOUSAND(1000),
        FIVE_HUNDRED(500),
        ONE_HUNDRED(100),
        FIFTY(50),
        TEN(10),
        ONE(1);

        private final int value;
        Bill(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static int getCapableBillCount(Bill bill, int money) {
        return money / bill.getValue();
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}
