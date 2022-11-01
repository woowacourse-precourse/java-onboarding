package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(9);
        try {
            constraint5(money);
        }
        catch(Exception e) {
            System.out.println("Problem5 exception : " + e.getMessage());
            return Collections.emptyList();
        }

        int [] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int unit : units) {
            int count = money/unit;
            answer.add(count);
            money -= unit*(count);
        }
        return answer;
    }
    static void constraint5(int money) throws Exception {
        if (money < 1 || money > 1000000) {
            throw new Exception("money는 1 이상 1,000,000 이하인 자연수이어야 한다.");
        }
    }
}

