package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] won = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int j = 0 ; j < 9; j ++){
            if(money / won[j] >0){
                answer.add(money/won[j]);
                //계산되어 answer에 값이 추가된 경우 그만큼 money에서 차감하는 기능
                money -= (won[j] * (money/won[j]));
            }
            else if(money / won[j] ==0){
                answer.add(0);
            }
        }

        return answer;
    }
}