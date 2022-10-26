package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 *  🚀 기능 명세
    입력으로 주어진 금액에 대응되는 각 금액권의 개수 배열을 반환하는 메서드(getNumberOfEachMonetaryUnit)

 */

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        return getNumberOfEachMonetaryUnit(money, answer);
    }

    public static List<Integer> getNumberOfEachMonetaryUnit(int money, List<Integer> monetaryList){
        List<Integer> monetaryUnitList = List.of(50000,10000,5000,1000,500,100,50,10,1);

        for(int i = 0 ; i < monetaryUnitList.size() ; i++){
            monetaryList.add(money / monetaryUnitList.get(i));
            money %= monetaryUnitList.get(i);
        }

        return monetaryList;
    }
}
