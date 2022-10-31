package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (validList(pobi) == false || validList(crong) == false)
            return -1;

        int pobiScore = calScore(pobi);
        int crongScore = calScore(crong);

        if (pobiScore > crongScore) return 1;
        if (pobiScore < crongScore) return 2;
        if (pobiScore == crongScore) return 0;

        return -1;
    }
}