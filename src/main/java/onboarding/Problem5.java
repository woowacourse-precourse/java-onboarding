package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int[] moneyTypes = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int moneyType: moneyTypes) {
            if(moneyType <= money) {
                int num = money/moneyType;
                answer.add(num);
                money = money % moneyType;
            } else {
                answer.add(0);
            }
        }
        System.out.println(answer);
        return answer;
    }
}
