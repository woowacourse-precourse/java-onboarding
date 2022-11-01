package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* 기능구현사항
* 1. 화폐단위 갯수를 반환하는 기능
* */
public class Problem5 {
    public static List<Integer> solution(int money) {
        return getMoneyList(money);
    }

    static List<Integer> getMoneyList(int money) {
        int[] exchangeList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> moneyList = new ArrayList<>();

        for (int i = 0; i < exchangeList.length; i++) {
            moneyList.add(money / exchangeList[i]);
            money %= exchangeList[i];
        }
        return moneyList;
    }
}
