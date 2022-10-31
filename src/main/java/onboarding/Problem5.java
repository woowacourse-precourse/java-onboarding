package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        try {
            if(!isIncludeMoney(money)) {
                throw new Exception("money의 범위는 1이상 1,000,000이하여야 합니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Integer> moneyList = withdrawMoney(money);
        return moneyList;
    }

    private static boolean isIncludeMoney(int money) {
        if(money>=1&&money<=1000000) return true;
        else return false;
    }

    private static List<Integer> withdrawMoney(int money) {
        List<Integer> moneyList = new ArrayList<>();
        moneyList.add(money / 50000);
        moneyList.add((money % 50000)/10000);
        moneyList.add((money % 10000)/5000);
        moneyList.add((money % 5000)/1000);
        moneyList.add((money % 1000)/500);
        moneyList.add((money % 500)/100);
        moneyList.add((money % 100)/50);
        moneyList.add((money % 50)/10);
        moneyList.add((money % 10)/1);

        return moneyList;
    }
}
