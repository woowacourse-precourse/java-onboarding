package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> moneyTypeList = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> withDrawResult = new ArrayList<>();

        for (int moneyType : moneyTypeList) {
            addNumberOfChange(withDrawResult, money, moneyType);
            money = updateRemainMoney(money, moneyType);
        }

        return withDrawResult;
    }

    private static int getNumberOfChange(int remainMoney, int moneyType) {
        return remainMoney / moneyType;
    }

    private static void addNumberOfChange(List<Integer> changeResult, int remainMoney, int moneyType) {
        changeResult.add(getNumberOfChange(remainMoney, moneyType));
    }

    private static int updateRemainMoney(int remainMoney, int moneyType) {
        return remainMoney - (getNumberOfChange(remainMoney, moneyType) * moneyType);
    }
}
