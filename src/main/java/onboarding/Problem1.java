package onboarding;

import java.util.List;
import java.util.Map;

class Problem1 {

    static boolean isVaild(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        if (rightPage - leftPage != -1)
            return false;

        if (leftPage >= 3 && leftPage <= 397) {
            return leftPage % 2 == 1;
        } else {
            return false;
        }
    }

    static int addCalc(List<Integer> pages) {
        int maxResult = 0;
        for (int page : pages) {
            int divisor = 100;
            int result = 0;
            while (divisor > 0) {
                result += (int) (page / divisor);
                page %= divisor;
                divisor /= 10;
            }
            maxResult= Math.max(maxResult, result);
        }
        return maxResult;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isVaild(pobi) || !isVaild(crong)) {
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}