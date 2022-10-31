package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> unitsList = new ArrayList<>();
        List<Integer> moneyUnitList = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        int remainder = money;

        for (Integer moneyUnit : moneyUnitList) {
            int units = getUnits(remainder, moneyUnit);
            remainder -= withdraw(units, moneyUnit);

            unitsList.add(units);
        }

        return unitsList;
    }

    private static int getUnits(int remainder, int moneyUnit) {
        return remainder / moneyUnit;
    }

    private static int withdraw(int units, int moneyUnit) {
        return units * moneyUnit;
    }
}
