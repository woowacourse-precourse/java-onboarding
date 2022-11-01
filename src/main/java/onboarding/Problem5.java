package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        // 제한 사항 1 - money는 1 이상 1,000,000 이하인 자연수이다.
        if (money < 1 || money > 1000000) {
            answer = List.of();
            return answer;
        }

        int[] moneyList = {50000,10000,5000,1000,500,100,50,10,1};
        int length = moneyList.length;
        for(int i = 0; i< length; i++){
            answer.add(money/moneyList[i]);
            money %= moneyList[i];
        }
        return answer;
    }
}
