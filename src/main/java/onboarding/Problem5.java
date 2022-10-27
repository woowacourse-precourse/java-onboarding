package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    private static boolean canConvertToFiftyThousand(int money) {
        if (money / 50000 != 0) return true;
        return false;
    }

    private static boolean canConvertToTenThousand(int money) {
        if (money / 10000 != 0) return true;
        return false;
    }

    private static boolean canConvertToFiveThousand(int money) {
        if (money / 5000 != 0) return true;
        return false;
    }

    private static boolean canConvertToOneThousand(int money) {
        if (money / 1000 != 0) return true;
        return false;
    }

    private static boolean canConvertToFiveHundred(int money) {
        if (money / 500 != 0) return true;
        return false;
    }

    private static boolean canConvertToOneHundred(int money) {
        if (money / 100 != 0) return true;
        return false;
    }

    private static boolean canConvertToFifty(int money) {
        if (money / 50 != 0) return true;
        return false;
    }

    private static boolean canConvertToTen(int money) {
        if (money / 10 != 0) return true;
        return false;
    }
}
