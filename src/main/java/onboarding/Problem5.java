package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int restMoney;
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static List<Integer> withdraw(){
        int[] moneyUnitList = {50000,10000,5000,1000,500,100,50,10,1};
        List<Integer> unitCount = new ArrayList<Integer>();
        for(int i = 0; i < moneyUnitList.length; i++){
            int unit = moneyUnitList[i];
            int count = countMoneyByUnit(unit);
            unitCount.add(count);
        }
        return unitCount;
    }

    public static int countMoneyByUnit(int unit){
        int count = restMoney / unit;
        restMoney = restMoney % unit;
        return count;
    }
}
