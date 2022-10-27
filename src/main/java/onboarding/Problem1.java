package onboarding;

import problem1.Validate;
import problem1.pageException;

import java.util.List;

import static java.lang.Math.max;
import static problem1.Calculate.*;
import static problem1.Validate.pageBoundaryCheck;
import static problem1.Validate.pageValidCheck;

class Problem1 {
    private static final int SUM = 0;
    private static final int MUL = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        try {
            int pobiMax = getMaxValue(pobi);
            int crongMax = getMaxValue(crong);

            answer = judge(pobiMax, crongMax);
        } catch (pageException e) {
            answer = -1;
        }

        return answer;
    }

    private static int judge(int pobiMax, int crongMax) {
        if(pobiMax > crongMax) return 1;
        else if(pobiMax < crongMax) return 2;
        else return 0;
    }

    private static void checkException(Integer left, Integer right) throws pageException {
        if (!(pageBoundaryCheck(left, right) && pageValidCheck(left, right))) {
            throw new pageException();
        }
    }
    private static int getMaxValue(List<Integer> pages) throws pageException {
        checkException(pages.get(0), pages.get(1));

        int maxVal = 0;
        for (Integer integer : pages) {
            maxVal = max(maxVal, max(digitCalculate(integer, SUM), digitCalculate(integer, MUL)));
        }
        return maxVal;
    }
}