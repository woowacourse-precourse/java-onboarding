package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static int[]moneyUnits = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        if (!isValid(money)){
            return new ArrayList<>();   // 조건이 맞지 않으면 빈 리스트를 반환.
        }

        countMoney(money, answer);

        return answer;
    }

    /**
     * 주어진 money가 범위안에 들어가는지 체크하는 메소드
     * @param money
     * @return
     */
    public static boolean isValid(int money){
        return 1 <= money && 1000000 >= money;
    }

    /**
     * 돈을 각 화폐에 맞게 나누어주는 메소드
     * @param money
     * @param answer
     * @return
     */
    public static List<Integer> countMoney(int money, List<Integer> answer){
        for(int i = 0; i < moneyUnits.length; i++){

            if (money / moneyUnits[i] != 0){        //화폐가 존재할수 있는지 체크
                answer.add(money / moneyUnits[i]);
                money %= moneyUnits[i];             //남은 돈 계산
                continue;
            }
            answer.add(0);                          //화폐가 존재하지 않다면 0으로 add
        }

        return answer;
    }

}
