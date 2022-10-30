package onboarding.problem5;

import java.util.Arrays;
import java.util.List;

public class Money {
    static final List<Integer> MONEY_LIST = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);
    public static List<Integer> splitMoney(int money) {
        List<Integer> resultList = Arrays.asList(0,0,0,0,0,0,0,0,0);
        for (int i = 0; i < MONEY_LIST.size(); i++) {
            int baseMoney = MONEY_LIST.get(i);
            if (Calculator.isBigger(money, baseMoney)) {
                int divi = Calculator.getQuotient(money, baseMoney);
                money = updateMoney(money, baseMoney);
                resultList.set(i, divi);
            }
        }
        return resultList;
    }
    public static int updateMoney(int money, int baseMoney) {
        int updatedMoney = money % baseMoney;
        return updatedMoney;
    }
}
