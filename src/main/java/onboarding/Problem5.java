package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {

    private static final int MONEY_50000 = 50000;
    private static final int MONEY_10000 = 10000;
    private static final int MONEY_5000 = 5000;
    private static final int MONEY_1000 = 1000;
    private static final int MONEY_500 = 500;
    private static final int MONEY_100 = 100;
    private static final int MONEY_50 = 50;
    private static final int MONEY_10 = 10;
    private static final int MONEY_1 = 1;

    public static List<Integer> solution(int money) {


        List<Integer> moneyValues = List.of(MONEY_50000, MONEY_10000, MONEY_5000,
                                            MONEY_1000, MONEY_500, MONEY_100,
                                            MONEY_50, MONEY_10, MONEY_1);
        int[] resultArr = new int[moneyValues.size()];
        
        for (int i = 0; i < resultArr.length; i++) {
            if (canChange(money, moneyValues.get(i))) {
                int change = getChange(money, moneyValues.get(i));
                resultArr[i] = change;

                money = getRest(money, moneyValues.get(i));
            }
        }

        List<Integer> resultList = Arrays.stream(resultArr)
                .boxed()
                .collect(Collectors.toList());

        return resultList;
    }

    private static boolean canChange(int money, int moneyValue) {
        if (money / moneyValue == 0) { //money_value가 money보다 크면
            return false;
        }
        return true;
    }

    private static int getChange(int money, int moneyValue) { //반환되는 돈
        return money / moneyValue;
    }
    private static int getRest(int money, int moneyValue) { //나머지 돈
        return money % moneyValue;
    }
}
