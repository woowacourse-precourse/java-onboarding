package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int[] moneyList={50000,10000,5000,1000,500,100,50,10,1};
        for (int i : moneyList) {
            if (money >= i) {
                int temp = money / i;
                money -= temp * i;
                answer.add(temp);
            } else {
                answer.add(0);
            }
        }
        return answer;
    }
}
