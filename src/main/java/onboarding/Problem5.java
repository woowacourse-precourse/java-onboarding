package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int countOfCoinUnit=9;
    public static Integer[] coinValueByCoinUnit=new Integer[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static int[] countCoinByCoinUnit(int money){
        int[] coinCountByCoinUnit=new int[]{0,0,0,0,0,0,0,0,0};
        for(int coinUnitIndex=0;coinUnitIndex<countOfCoinUnit;coinUnitIndex++){
            int coinCountByUnit=money/coinValueByCoinUnit[coinUnitIndex];
            money-=coinCountByUnit*coinValueByCoinUnit[coinUnitIndex];
            coinCountByCoinUnit[coinUnitIndex]=coinCountByUnit;
        }
        return coinCountByCoinUnit;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}
