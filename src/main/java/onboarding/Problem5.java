package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    static int[] unitOfMoney = new int[] {50000,10000,5000,1000,500,100,50,10,1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList();
        for (int unit : unitOfMoney) {
            int[] quotaAndRemainder = returnQuotaAndRemainder(money, unit);
            int quota = quotaAndRemainder[0];
            int remainder = quotaAndRemainder[1];
            answer.add(quota);
            money = remainder;
        }
        return answer;
    }

    private static int[] returnQuotaAndRemainder (int number, int divider) {
        int quota = number / divider;
        int remainder = number % divider;
        return new int[] {quota, remainder};
    }
}
