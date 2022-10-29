package onboarding.problem1;

import static onboarding.problem1.consts.GameResultConst.EXCEPTION_RESULT;
import static onboarding.problem1.consts.PlayerNameConst.CRONG_NAME;
import static onboarding.problem1.consts.PlayerNameConst.POBI_NAME;

import java.util.List;

public class GamePlayer {

    private GamePlayer() {
    }

    public static int play(List<Integer> pobi, List<Integer> crong) {
        PageGameInfo pageGame = new PageGameInfo();

        try {
            registryTwoPlayers(pageGame, pobi, crong);
        } catch (IllegalArgumentException e) {
            return EXCEPTION_RESULT;
        }
        return pageGame.playGameResult(POBI_NAME, CRONG_NAME);
    }

    private static void registryTwoPlayers(PageGameInfo pageGame, List<Integer> pobiPage,
        List<Integer> crongPage) {
        pageGame.registryPlayer(POBI_NAME, pobiPage);
        pageGame.registryPlayer(CRONG_NAME, crongPage);
    }
}
