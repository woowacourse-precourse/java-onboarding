package onboarding;

import java.util.List;

class Problem1 {
    private static final int WRONG_INPUT = -1;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;

    private static boolean isWrongInput(List<Integer> pages) {
        if (pages.size() != 2)
            return true;

        int left = pages.get(0);
        int right = pages.get(1);

        if (left % 2 != 1 || right - left != 1 || left <= 1 || right >= 400)
            return true;

        return false;
    }

    private static int getMyScore(List<Integer> pages) {

        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        return Math.max(getMaxScoreOnEachPage(leftPage), getMaxScoreOnEachPage(rightPage));
    }

    private static int getMaxScoreOnEachPage(int page) {

        return Math.max(getScoreBySumAllDigits(page), getScoreByMulAllDigits(page));
    }

    private static int getScoreBySumAllDigits(int page) {

        int score = 0;

        while (page > 0) {
            score += page % 10;

            page /= 10;
        }

        return score;
    }

    private static int getScoreByMulAllDigits(int page) {

        int score = 1;

        while (page > 0) {
            score *= page % 10;

            page /= 10;
        }

        return score;
    }

    /**
     * 1. 책을 임의로 펼친다.
     * 2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
     * 3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
     * 4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
     * 5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
     * 6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
     *
     * @param pobi 포비가 펼친 페이지
     * @param crong 크롱이 펼친 페이지
     * @return 게임 결과, 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isWrongInput(pobi) || isWrongInput(crong)) {
            return WRONG_INPUT;
        }

        int pobiScore = getMyScore(pobi);
        int crongScore = getMyScore(crong);

        if (pobiScore > crongScore) {
            return POBI_WIN;
        }

        if (pobiScore < crongScore) {
            return CRONG_WIN;
        }

        return DRAW;
    }
}