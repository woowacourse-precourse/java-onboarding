package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Problem5 {
    static int countOfCoinUnit=9;
    public static Integer[] coinValueByCoinUnit=new Integer[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> countCoinByCoinUnit(int money){
        List<Integer> coinCountByCoinUnit=new ArrayList<>();
        for(int coinUnitIndex=0;coinUnitIndex<countOfCoinUnit;coinUnitIndex++){
            int coinCountByUnit=money/coinValueByCoinUnit[coinUnitIndex];
            money-=coinCountByUnit*coinValueByCoinUnit[coinUnitIndex];
            coinCountByCoinUnit.set(coinUnitIndex, coinCountByUnit);
        }
        return coinCountByCoinUnit;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer=countCoinByCoinUnit(money);
        return answer;
    }
}
