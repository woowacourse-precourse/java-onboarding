package onboarding.problem1;

import java.util.List;

public class Game {

    /**
     * 포비와 크롱의 점수를 비교하여 게임 결과에 따른 값 반환하는 메서드
     * 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0
     * 예외사항은 -1
     */
    public static Integer getGameResult(List<Integer> pobi, List<Integer> crong) {

        try {
            Page pobiPage = new Page(pobi);
            Page crongPage = new Page(crong);

            int pobiScore = pobiPage.getScore();
            int crongScore = crongPage.getScore();

            if (pobiScore > crongScore) {
                return Constants.POBI_WINS;
            }
            else if (pobiScore < crongScore) {
                return Constants.CRONG_WINS;
            }
            else {
                return Constants.DRAW;
            }
        } catch (IllegalArgumentException exception) {
            return Constants.EXCEPTION;
        }

    }

}
