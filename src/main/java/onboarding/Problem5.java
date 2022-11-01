package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    final static int[] UNITMONEY = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = getCountOfUnitMoney(money);
        return answer;
    }

    /**
     * money가 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 각 몇 개로 변환되는지를 리스트로 반환
     */
    public static List<Integer> getCountOfUnitMoney(int money){
        List<Integer> countOfUnitMoney = new ArrayList<Integer>();
        for(int i = 0; i< UNITMONEY.length; i++){
            countOfUnitMoney.add(money/UNITMONEY[i]);
            money %= UNITMONEY[i];
        }
        return countOfUnitMoney;
    }
}
