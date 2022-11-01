package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    static int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int count = 0;
        for(int i=0; i<moneyList.length; i++){
            count = money / moneyList[i];
            money = money % moneyList[i];
            answer.add(count);
        }
        return answer;
    }
}
