package onboarding;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    private final int MIN_PAGE = 0;
    private final int MAX_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }

    public boolean isRightPageNumbers(List<Integer> playersPages) {
        final int leftPageNumber = playersPages.get(0);
        final int rightPageNumber = playersPages.get(1);

        if (leftPageNumber % 2 == 0) {  // 왼쪽 페이지가 짝수일 경우
            return false;
        }
        else if (leftPageNumber < MIN_PAGE) {   // 최소 페이지보다 작을 경우
            return false;
        }
        else if (rightPageNumber > MAX_PAGE) {  // 최대 페이지보다 클 경우
            return false;
        }
        else if (rightPageNumber - leftPageNumber != 1) {    // 페이지가 연속되지 않는 경우
            return false;
        }

        return true;
    }

    public int getMaxValue(List<Integer> playersPages){
        final int maxLeftPageNumber = calculateInSingleNumber(playersPages.get(0));
        final int maxRightPageNumber = calculateInSingleNumber(playersPages.get(1));

        return max(maxLeftPageNumber, maxRightPageNumber);
    }

    public int calculateInSingleNumber(int pageNumber){
        int sum = 0;
        int mul = 1;

        while (pageNumber > 0) {
            int mod = pageNumber % 10;
            sum += mod;
            mul *= mod;
            pageNumber /= 10;
        }

        return max(sum,mul);
    }

}
