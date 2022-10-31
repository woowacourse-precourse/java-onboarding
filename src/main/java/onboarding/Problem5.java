package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] moneyArray = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<>();
        for (int criteria : moneyArray) {
            int[] result = transMoney(money, criteria);
            money = result[1];
            answer.add(result[0]);
        }
        return answer;
    }
    // 50,000, 10,000, 5000, 1000, 500, 100, 50, 10, 1
    // 돈 변환 로직
    public static int[] transMoney(int money, int criteria){
        int count = money / criteria;
        int charge = money % criteria;
        return new int[]{count, charge};
    }
}
