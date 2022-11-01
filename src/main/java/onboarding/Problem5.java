package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

    }
    public static int fiveTimesUnitCalculate(int money,int digit){
        int currentMoney = money;
        int fiveTimesUnit =0;

        while(currentMoney / digit >= 5){
            fiveTimesUnit++;
            currentMoney -= 5*digit;
        }
        return fiveTimesUnit;
    }
    public static int unitCalculate(int money, int digit){
        int currentMoney = money;
        int unit=0;

        while(currentMoney / digit > 0){
            unit++;
            currentMoney -= digit;
        }

        return unit;
    }
}
