package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    static int[] moneyUnits = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };

    public static int[] changeMoney(int unit, int money) {
        return new int[] { money / unit, money % unit };
    }
    
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for (int unit : moneyUnits) {
            int[] result = changeMoney(unit, money);

            money = result[1];
            answer.add(result[0]);
        }
        
        return answer;
    }
}
