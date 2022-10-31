package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static boolean checkParam(int n)
    {
        return n < 1 || 1000000 < n;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int fiveMoney = 50000;
        int oneMoney = 10000;

        if (checkParam(money)) {
            return Collections.emptyList();
        }
        while (oneMoney != 0)
        {
            if (fiveMoney != 5) {
                answer.add(money / fiveMoney);
                money %= fiveMoney;
                fiveMoney /= 10;
            }
            answer.add(money / oneMoney);
            money %= oneMoney;
            oneMoney /= 10;
        }
        return answer;
    }
}
