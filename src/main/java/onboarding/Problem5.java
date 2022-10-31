package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static int moneyChange(int money, int unit) {
        int count = 0;
        if(money >= unit){
            count = Math.floorDiv(money,unit);
        }
        return count;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] unitList = {50000,10000,5000,1000,500,100,50,10,1};
        int currentMoney = money;
        int countByUnit = 0;

        for(int index = 0; index < unitList.length; index++){
            countByUnit = moneyChange(currentMoney,unitList[index]);
            answer.add(countByUnit);
            currentMoney -= unitList[index] * countByUnit;
        }

        return answer;
    }
}
