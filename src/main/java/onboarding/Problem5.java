package onboarding;

import ExceptionValidation.P5ExceptionValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        if(!(P5ExceptionValidation.p5ExceptionValidation(money))){
            return Collections.emptyList();
        }

        List<Integer> remainedMoneyList = findRemainedMoney(money);

        return remainedMoneyList;
    }

    public static List<Integer> findRemainedMoney(int money) {

        List<Integer> remainedMoneyList = new ArrayList<>();
        int division;
        List<Integer> divisionList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for (int i = 0; i <= 8; i++) {
            division = divisionList.get(i);
            if (money / division > 0) {
                remainedMoneyList.add(money / division);
                money = money % division;
            } else {
                remainedMoneyList.add(0);
            }
        }

        return remainedMoneyList;
    }
}

