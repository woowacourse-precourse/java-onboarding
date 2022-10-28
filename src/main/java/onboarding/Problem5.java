package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static final int START_INDEX = 0;
    public static final int UNIT_NUMBER = 9;

    public static List<Integer> solution(int money) {
        List<Integer> answer = atm(initUnit(), money);

        return answer;
    }

    public static int[] initUnit() {
        int[] unit = new int[UNIT_NUMBER];

        unit[0] = 50000;
        unit[1] = 10000;
        unit[2] = 5000;
        unit[3] = 1000;
        unit[4] = 500;
        unit[5] = 100;
        unit[6] = 50;
        unit[7] = 10;
        unit[8] = 1;

        return unit;
    }

    public static List<Integer> atm(int[] unit, int money) {
        List<Integer> result = new ArrayList<>();

        for (int index = START_INDEX; index < unit.length; index++) {
            result.add(money / unit[index]);
            money %= unit[index];
        }

        return result;
    }
}