package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        return new ArrayList<>();
    }

    enum Money {
        _50000_WON(50000),
        _10000_WON(10000),
        _5000_WON(5000),
        _1000_WON(1000),
        _500_WON(500),
        _100_WON(100),
        _50_WON(50),
        _10_WON(10),
        _1_WON(1);

        int value;

        Money(int value) {
            this.value = value;
        }
    }
}
