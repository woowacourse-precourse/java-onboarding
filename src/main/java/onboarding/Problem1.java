package onboarding;

import java.util.List;
import onboarding.problem1.Page;

class Problem1 {
    private static final Integer POBI_WIN_NUMBER = 1;
    private static final Integer CRONG_WIN_NUMBER = 2;
    private static final Integer DROW_NUMBER = 0;
    private static final Integer EXCEPTION_NUMBER = -1;

    /*
    * 펼친 페이지 가운데 가장 큰 스코어 반환
    */
    private static int getMaxScore(List<Integer> pages) {
        int maxScore = 0;
        for (int page : pages) {
            Page pageNumber = new Page(page);

            if (pageNumber.sumOfDigit() == 0 || pageNumber.multiplyOfDigit() == 0) {
                throw new Error("점수가 유효하지 않습니다.");
            }

            int newScore = Math.max(pageNumber.sumOfDigit(), pageNumber.multiplyOfDigit());
            maxScore = Math.max(newScore, maxScore);
        }

        return maxScore;
    }

    /*
     * 페이지 번호 게임의 결과 반환
     */
    private static int getPageNumberGameResult(int pobiScore, int crongScore) {

        if (pobiScore > crongScore) {
            return POBI_WIN_NUMBER;

        } else if (pobiScore < crongScore) {
            return CRONG_WIN_NUMBER;

        } else {
            return DROW_NUMBER;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        try {

            int pobiMaxScore = getMaxScore(pobi);
            int crongMaxScore = getMaxScore(crong);

            return getPageNumberGameResult(pobiMaxScore, crongMaxScore);

        } catch (Error e) {
            return -1;
        }
    }
}