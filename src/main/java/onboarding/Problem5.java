package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] monetary_unit={50000,10000,5000,1000,500,100,50,10,1}; // 화폐 단위
        for(int i:monetary_unit) {
            answer.add(money / i);
            money %= i;
        }
        return answer;
    }
}
