package onboarding;

import java.util.*;

public class Problem5 {

    private static int withdrawMoney;
    private static Map<Integer, Integer> moneyMap;

    public static List<Integer> solution(int inputWithdrawMoney) {
        withdrawMoney = inputWithdrawMoney;
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static Map<Integer, Integer> initMoneyMap() {
        moneyMap.put(50000, 0);
        moneyMap.put(10000, 0);
        moneyMap.put(5000, 0);
        moneyMap.put(1000, 0);
        moneyMap.put(500, 0);
        moneyMap.put(100, 0);
        moneyMap.put(50, 0);
        moneyMap.put(10, 0);
        moneyMap.put(1, 0);
        return moneyMap;
    }

    public static void inputMoney(int moneyUnit, int numberOfMoney) {
        moneyMap.put(moneyUnit, numberOfMoney);
    }
}
