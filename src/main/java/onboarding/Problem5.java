package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int[] unitOfMoney = new int[] {50000,10000,5000,1000,500,100,50,10,1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    private static int[] returnQuotaAndRemainder (int number, int divider) {
        int quota = number / divider;
        int remainder = number % divider;
        return new int[] {quota, remainder};
    }
}
