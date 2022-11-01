package onboarding;

import java.util.*;

class Problem1 {
    private static int sum;
    private static int Biggest;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return whoseBiggest(pobi, crong);
    }
}