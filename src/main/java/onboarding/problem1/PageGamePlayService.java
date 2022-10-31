package onboarding.problem1;

import static onboarding.problem1.consts.GameResultConst.EXCEPTION_RESULT_VALUE;
import static onboarding.problem1.consts.PlayerNameConst.CRONG_NAME;
import static onboarding.problem1.consts.PlayerNameConst.POBI_NAME;

import java.util.List;

/**
 * 게임을 진행하는 클래스
 */
public class PageGamePlayService {

    private PageGamePlayService() {
    }

    /**
     * 페이지 게임을 진행하고 결과를 반환하는 메소드
     *
     * @param pobi  첫 번째 플레이어 pobi
     * @param crong 두 번째 플레이어 crong
     * @return 게임 결과(무승부 : 0, pobi 승리 : 1, crong 승리 : 2)
     * @throws IllegalArgumentException 유효한 페이지가 아닌 경우
     */
    public static int play(List<Integer> pobi, List<Integer> crong) {
        PageGameRepository pageGame = new PageGameRepository();

        try {
            registryTwoPlayers(pageGame, pobi, crong);
        } catch (IllegalArgumentException e) {
            return EXCEPTION_RESULT_VALUE;
        }
        return pageGame.play(POBI_NAME, CRONG_NAME);
    }

    /**
     * 두 명의 플레이어를 PageGameRepository에 저장하는 메소드
     *
     * @param pageGame  플레이어의 정보를 관리하는 일급 컬렉션
     * @param pobiPage  첫 번째 플레이어(pobi)의 왼쪽, 오른쪽 페이지 정보
     * @param crongPage 두 번째 플레이어(crong)의 왼쪽, 오른쪽 페이지 정보
     */
    private static void registryTwoPlayers(PageGameRepository pageGame, List<Integer> pobiPage,
        List<Integer> crongPage) {
        pageGame.registryPlayer(POBI_NAME, pobiPage);
        pageGame.registryPlayer(CRONG_NAME, crongPage);
    }
}
