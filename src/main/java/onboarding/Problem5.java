package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    static List<Integer> unitList;

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        initUnitList();
        for (Integer unit : unitList) {
            answer.add(getUnitCount(money, unit));
            money = getNextMoney(money, unit);
        }
        return answer;
    }

    public static void initUnitList(){
        unitList = new ArrayList<>();
        unitList.add(50000);
        unitList.add(10000);
        unitList.add(5000);
        unitList.add(1000);
        unitList.add(500);
        unitList.add(100);
        unitList.add(50);
        unitList.add(10);
        unitList.add(1);
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
