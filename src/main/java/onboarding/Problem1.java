package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiNum = numCalculator(pobi);
        int crongNum = numCalculator(crong);
        if (exceptionHandler(pobi) || exceptionHandler(crong)) {
            return -1;
        } else if (pobiNum > crongNum) {
            return 1;
        } else if (crongNum > pobiNum) {
            return 2;
        } else {
            return 0;
        }
    }
}