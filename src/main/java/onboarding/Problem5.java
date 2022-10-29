package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> moneyList = new ArrayList<>();
    public static List<Integer> divideList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    private int doDivide(int money, int divideUnit) {
        int quotient = money / divideUnit;
        int remainder = money % divideUnit;
        return remainder;
    }
    public static List<Integer> solution(int money) {
        int count = 0;
        while (moneyList.size() != 9) {
            int divideUnit = divideList.get(count);
            int quotient = money / divideUnit;
            moneyList.add(quotient);
            int remainder = money % divideUnit;
            money = remainder;
            count++;
        }
        return moneyList;
    }
}
