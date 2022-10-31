package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        if (money < 0 || money > 1000000) System.exit(1);
        List<Integer> answer = new ArrayList<>();
        int[] moneyList = {50000,10000,5000,1000,500,100,50,10,1};
        int length = moneyList.length;
        for(int i = 0; i< length; i++){
            int x = moneyList[i];
            int count = money/x;
            money %= x;
            answer.add(count);
        }
        return answer;
    }
}
