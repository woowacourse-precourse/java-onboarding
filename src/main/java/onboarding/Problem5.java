package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int[] sort_money = new int[]{50000,10000,5000,1000,500,100,50,10,1};
        int money_ = money;

        for(int i=0; i<sort_money.length;i++) {
            answer.add(money_/sort_money[i]);
            money_ = money_% sort_money[i];
        }

        return answer;
    }
}
