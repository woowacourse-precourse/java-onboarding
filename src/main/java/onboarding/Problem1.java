package onboarding;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    private static final int MIN_PAGE = 0;
    private static final int MAX_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return gameStarter(pobi, crong);
    }

    private static boolean isRightPageNumbers(List<Integer> playersPages) {
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

    private static int getMaxValue(List<Integer> playersPages){
        final int maxLeftPageNumber = calculateInSingleNumber(playersPages.get(0));
        final int maxRightPageNumber = calculateInSingleNumber(playersPages.get(1));

        return max(maxLeftPageNumber, maxRightPageNumber);
    }

    private static int calculateInSingleNumber(int pageNumber) {
        int sum = 0;
        int mul = 1;
        int mod;

        while (pageNumber > 0) {
            mod = pageNumber % 10;
            sum += mod;
            mul *= mod;
            pageNumber /= 10;
        }

        return max(sum,mul);
    }

    private static int gameStarter(List<Integer> player1, List<Integer> player2) {
        if (isRightPageNumbers(player1) == false || isRightPageNumbers(player2) == false) {
            return -1;
        }
        int player1sScore = getMaxValue(player1);
        int player2sScore = getMaxValue(player2);

        if (player1sScore > player2sScore) {    // player1이 더 클 경우
            return 1;
        }
        else if (player1sScore < player2sScore) {   // player2가 더 클 경우
            return 2;
        }
        else {  // 무승부 일 경우
            return 0;
        }

    }

}
