package onboarding.problem5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Money {
    static final List<Integer> CHANGE_LIST = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);

    public static List<Integer> splitMoney(int money) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < CHANGE_LIST.size(); i++) {
            int change = CHANGE_LIST.get(i);
            int quotient = Calculator.getQuotient(money, change);
            money = getSurplus(money, change);
            resultList.add(quotient);
        }
        return resultList;
    }

    public static int getSurplus(int money, int baseMoney) {
        return money % baseMoney;
    }
}
