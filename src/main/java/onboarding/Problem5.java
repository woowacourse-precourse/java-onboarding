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

    public static void main(String[] args) {
        System.out.println(solution(50237));
        System.out.println(solution(15000));
    }

    public static List<Integer> solution(int money) {
        int[] money_values = {MONEY_50000, MONEY_10000, MONEY_5000, MONEY_1000, MONEY_500, MONEY_100, MONEY_50, MONEY_10, MONEY_1};
        List<Integer> resultList = new ArrayList<>();


        for (int i = 0; i < money_values.length; i++) {
            if (canChange(money, money_values[i])) {
                int change = getChange(money, money_values[i]);
                resultList.add(change);
                money = getRest(money, money_values[i]);
            }
            else {
                resultList.add(0);
            }
        }

        return resultList;
    }

    private static boolean canChange(int money, int money_value) {
        if (money / money_value == 0) { //money_value가 money보다 크면
            return false;
        }
        return true;
    }

    private static int getChange(int money, int money_value) { //반환되는 돈
        return money / money_value;
    }
    private static int getRest(int money, int money_value) { //나머지 돈
        return money % money_value;
    }
}
