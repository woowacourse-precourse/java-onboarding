package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static final int MONEY_LOWERBOUND = 1;
    static final int MONEY_UPPERBOUND = 1_000_000;
    static final List<Integer> MONEY_LIST = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static boolean ValidationCheck(int money) {
        if (MONEY_LOWERBOUND <= money && money <= MONEY_UPPERBOUND) {
            return true;
        }
        return false;
    }
}


