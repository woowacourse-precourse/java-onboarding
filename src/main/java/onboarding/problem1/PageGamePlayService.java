package onboarding.problem1;

import static onboarding.problem1.consts.GameResultConst.EXCEPTION_RESULT_VALUE;
import static onboarding.problem1.consts.PlayerNameConst.CRONG_NAME;
import static onboarding.problem1.consts.PlayerNameConst.POBI_NAME;

import java.util.List;

public class PageGamePlayService {

    private PageGamePlayService() {
    }

    public static int play(List<Integer> pobi, List<Integer> crong) {
        PageGameRepository pageGame = new PageGameRepository();

        try {
            registryTwoPlayers(pageGame, pobi, crong);
        } catch (IllegalArgumentException e) {
            return EXCEPTION_RESULT_VALUE;
        }
        return pageGame.play(POBI_NAME, CRONG_NAME);
    }

    private static void registryTwoPlayers(PageGameRepository pageGame, List<Integer> pobiPage,
        List<Integer> crongPage) {
        pageGame.registryPlayer(POBI_NAME, pobiPage);
        pageGame.registryPlayer(CRONG_NAME, crongPage);
    }
}
