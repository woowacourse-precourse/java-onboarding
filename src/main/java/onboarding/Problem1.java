package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiMax = getMaxValueFromList(pobi);
        int crongMax = getMaxValueFromList(crong);
        if (pobiMax > crongMax) {
            return 1;
        } else if (pobiMax < crongMax) {
            return 2;
        }
        return 0;
    }
}