package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static int moneyForCalculate;
    public static final int START_INDEX = 0;
    public static int[] unit = new int[9];

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();

        initUnit();
        atm(money, answer);

        return answer;
    }

    public static void initUnit() {
        unit[0] = 50000;
        unit[1] = 10000;
        unit[2] = 5000;
        unit[3] = 1000;
        unit[4] = 500;
        unit[5] = 100;
        unit[6] = 50;
        unit[7] = 10;
        unit[8] = 1;
    }

    public static void atm(int money, List<Integer> answer) {
        moneyForCalculate = money;

        for (int index = START_INDEX; index < unit.length; index++) {
            answer.add(moneyForCalculate / unit[index]);
            moneyForCalculate %= unit[index];
        }
    }
}