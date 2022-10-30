package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for(int u:unit){
            if(isBiggerOrEqualThanUnit(money, u)){
                int unitCnt = countUnitInMoney(money, u);
                answer.add(unitCnt);
                money-=u*unitCnt;
            }
            else answer.add(0);
        }
        return answer;
    }

    private static int countUnitInMoney(int num, int u){
        return num / u;
    }

    private static boolean isBiggerOrEqualThanUnit(int num, int u){
        return num >= u;
    }
}
