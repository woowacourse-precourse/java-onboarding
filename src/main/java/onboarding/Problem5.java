package onboarding;

import java.util.*;
import onboarding.exceptions.*;

public class Problem5 {
    static void numberRangeExceptionCheck(int numIn) throws NumberRangeException {
        if (numIn < 1 || numIn > 1000000) {
            throw new NumberRangeException();
        }
    }
    static final int[] currency = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    static final int totalLen = 9;
    static List<Integer> result;

    static void transformer(int money) {
        int quotient;
        for (int i = 0; i < totalLen; i++) {
            quotient = money / currency[i];
            result.add(quotient);
            money -= quotient * currency[i];
        }
    }

    public static List<Integer> solution(int money) {
        try {
            result = new ArrayList<>();
            numberRangeExceptionCheck(money);
            transformer(money);
            return result;
        } catch (NumberRangeException e) {
            System.err.println("check the range of given number: " + money);
            return Collections.emptyList();
        }
    }
}
