package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    static List<Integer> result;

    public static List<Integer> solution(int money) {
        result = new ArrayList<>();
        int[] divide = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int remainder = money;

        for (int range: divide){
            remainder = divideMoney(remainder, range);
        }

//        System.out.println(result);
        return result;
    }

    private static int divideMoney(int money, int range){
        int quotient = money / range; // 몫
        int remainder = money % range; // 나머지

        result.add(quotient);
        return remainder;
    }
}
