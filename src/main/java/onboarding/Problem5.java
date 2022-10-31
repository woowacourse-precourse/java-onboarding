package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static List<Integer> moneyList;

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static void initMoneyList(){
        moneyList = new ArrayList<>();
        moneyList.add(50000);
        moneyList.add(10000);
        moneyList.add(5000);
        moneyList.add(1000);
        moneyList.add(500);
        moneyList.add(100);
        moneyList.add(50);
        moneyList.add(10);
        moneyList.add(1);
    }

    public static int getUnitCount(int money, int unit){
        if(money >= unit){
            return money/unit;
        }
        return 0;
    }

    public static int getNextMoney(int money, int unit){
        return money % unit;
    }
}
