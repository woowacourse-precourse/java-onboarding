package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {

    private static final List<Integer> moneyList = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);
    public static List<Integer> solution(int money) {

        List<Integer> resultList = new ArrayList<>();

        for (int i=0; i<moneyList.size(); i++){

            int moneyUnit = moneyList.get(i);
            if (money / moneyList.get(i) != 0){
                resultList.add(money / moneyUnit);
                money = money % moneyUnit;
            }else{
                resultList.add(0);
            }
        }

        return resultList;
    }
}
