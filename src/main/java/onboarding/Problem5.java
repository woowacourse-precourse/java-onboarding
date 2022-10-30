package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    enum Money {
        fiftyThs(50000),
        tenThs(10000),
        fiveThs(5000),
        oneThs(1000),
        fiveHnd(500),
        oneHnd(100),
        fifty(50),
        ten(10),
        one(1);

        private final  int value;
        Money(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();



        return answer;
    }
}
