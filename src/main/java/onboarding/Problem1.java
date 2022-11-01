package onboarding;

import java.util.List;
import onboarding.problem1.Page;

class Problem1 {

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

    private static int getPageNumberGameResult(int pobiScore, int crongScore) {

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else {
            return 0;
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