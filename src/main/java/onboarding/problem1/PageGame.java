package onboarding.problem1;

import java.util.List;

public class PageGame {
    private static final Integer POBI_WIN_NUMBER = 1;
    private static final Integer CRONG_WIN_NUMBER = 2;
    private static final Integer DROW_NUMBER = 0;


    /*
     * 페이지 리스트 중 가장 큰 스코어 반환
     */
    public static int getMaxScore(List<Integer> pages) {
        int maxScore = 0;
        for (int page : pages) {
            Page pageNumber = new Page(page);

            if (pageNumber.sumOfDigit() <= 0 || pageNumber.multiplyOfDigit() <= 0) {
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
    public static int getPageNumberGameResult(int pobiScore, int crongScore) {

        if (pobiScore > crongScore) {
            return POBI_WIN_NUMBER;

        } else if (pobiScore < crongScore) {
            return CRONG_WIN_NUMBER;

        } else {
            return DROW_NUMBER;
        }
    }
}
