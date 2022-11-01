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

    private static <pobi, crong> int whoseBiggest(List<Integer> pobi, List<Integer> crong){
        Biggest=(error(pobi)||error(crong)) ? EXCEPTION:
                (myBiggest(pobi)<myBiggest(crong)) ? 2: (myBiggest(pobi)>myBiggest(crong)) ? 1:0;
        return Biggest;
    }
}