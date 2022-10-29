package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static final int[] DIVISORS=new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> divideByAllDivisors(int dividend){
        ArrayList<Integer> result=new ArrayList<>();

        for (int divisor : DIVISORS) {
            result.add(dividend / divisor);
            dividend %= divisor;
        }

        return result;
    }

    public static List<Integer> solution(int money) {
        return divideByAllDivisors(money);
    }
}
