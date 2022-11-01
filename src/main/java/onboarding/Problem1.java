package onboarding;

import java.util.List;

class Problem1 {

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
        Player playerPobi = new Player();
        Player playerCrong = new Player();

        playerPobi.setPage(pobi);
        playerCrong.setPage(crong);

        PageGame pageGame = new PageGame();
        return pageGame.play(playerPobi, playerCrong);
    }

}
class Player {
    private int leftPage;
    private int rightPage;
    private boolean pageStatus = false;

    public void setPage(List<Integer> pages) {
        this.pageStatus = false;

        if (!isOnlyTwoPages(pages)) {
            return;
        }

        leftPage = pages.get(0);
        rightPage = pages.get(1);

        if (isWrongInput()) {
            return;
        }

        this.pageStatus = true;
    }

    private boolean isOnlyTwoPages(List<Integer> pages) {
        return pages.size() == 2;
    }

    private boolean isWrongInput() {

        if (leftPage % 2 != 1 || leftPage + 1  != rightPage || leftPage <= 1 || rightPage >= 400) {
            return true;
        }

        return false;
    }

    public boolean notReady() {
        return !pageStatus;
    }

    public int getLeftPage() {
        return leftPage;
    }

    public int getRightPage() {
        return rightPage;
    }
}
class PageGame {
    private static final int WRONG_INPUT = -1;
    private static final int PLAYER1_WIN = 1;
    private static final int PLAYER2_WIN = 2;
    private static final int DRAW = 0;

    public int play(Player player1, Player player2) {

        if (player1.notReady() || player2.notReady()) {
            return WRONG_INPUT;
        }

        int player1Score = getScore(player1);
        int player2Score = getScore(player2);

        return getGameResult(player1Score, player2Score);
    }


    private int getScore(Player player) {
        int leftPageMaxScore = getMaxScoreOnEachPage(player.getLeftPage());
        int rightPageMaxScore = getMaxScoreOnEachPage(player.getRightPage());

        return Math.max(leftPageMaxScore, rightPageMaxScore);
    }

    private int getMaxScoreOnEachPage(int page) {
        int sumScore = getScoreBySumAllDigits(page);
        int mulScore = getScoreByMulAllDigits(page);

        return Math.max(sumScore, mulScore);
    }

    private int getScoreBySumAllDigits(int page) {

        int score = 0;

        while (page > 0) {
            score += page % 10;

            page /= 10;
        }

        return score;
    }

    private int getScoreByMulAllDigits(int page) {

        int score = 1;

        while (page > 0) {
            score *= page % 10;

            page /= 10;
        }

        return score;
    }

    private int getGameResult(int player1Score, int player2Score) {

        if (player1Score > player2Score) {
            return PLAYER1_WIN;
        }

        if (player1Score < player2Score) {
            return PLAYER2_WIN;
        }

        return DRAW;
    }

}