package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return convertMoney(money);
    }

    private static List<Integer> convertMoney(int money){
        List<Integer> answer = new ArrayList<>();
        List<Integer> unitMoneyList = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));

        int remainder = money;

        for(int unitMoney: unitMoneyList){
            answer.add(remainder/unitMoney);
            remainder = remainder % unitMoney;
        }

        return answer;
    }
}
