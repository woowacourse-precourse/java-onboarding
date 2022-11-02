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
        unitList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    }

    public static int getUnitCount(int money, int unit){
        return money/unit;
    }

    public static int getNextMoney(int money, int unit){
        return money % unit;
    }
}
