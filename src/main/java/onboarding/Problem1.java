package onboarding;

import static onboarding.problem1.consts.GameResultConst.EXCEPTION_RESULT;
import static onboarding.problem1.consts.PlayerNameConst.*;

import java.util.List;
import onboarding.problem1.PageGameInfo;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        PageGameInfo pageGame = new PageGameInfo();

        try {
            registryPlayers(pageGame, pobi, crong);
        } catch (IllegalArgumentException e) {
            return EXCEPTION_RESULT;
        }
        return pageGame.playGameResult(POBI_NAME, CRONG_NAME);
    }

    private static void registryPlayers(PageGameInfo pageGame, List<Integer> pobi,
        List<Integer> crong) {
        pageGame.registryPlayer(POBI_NAME, pobi);
        pageGame.registryPlayer(CRONG_NAME, crong);
    }
}