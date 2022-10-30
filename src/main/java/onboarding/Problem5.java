package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public enum MonetaryUnit {
        FiftyThousand(50000),
        TenThousand(10000),
        FiveThousand(5000),
        OneThousand(1000),
        FiveHundred(500),
        OneHundred(100),
        Fifty(50),
        Ten(10),
        One(1);

        private final int value;

        MonetaryUnit(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        MonetaryUnit[] monetaryUnits = MonetaryUnit.values();

        while (money > 0) {
            for(MonetaryUnit mu : monetaryUnits) {
                answer.add(money % mu.getValue());
                money %= mu.getValue();
            }
        }

        return answer;

    }
}
