package onboarding.problem1;

import onboarding.problem1.page.Player;
import onboarding.problem1.page.PlayerFactory;

import java.util.List;

import static onboarding.problem1.GameResults.*;

public class BookGame {

    private final PageCalculator pageCalculator;
    private final PlayerFactory playerFactory;

    public BookGame(PageCalculator pageCalculator, PlayerFactory playerFactory) {
        this.pageCalculator = pageCalculator;
        this.playerFactory = playerFactory;
    }

    public int doBookGame(List<Integer> firstPages, List<Integer> secondPages) {
        // 게임을 수행하는 메서드
        try {
            Player firstPlayer = playerFactory.getPlayer(firstPages);
            Player secondPlayer = playerFactory.getPlayer(secondPages);

            return getWinner(pageCalculator.getResult(List.of(firstPlayer, secondPlayer)));

        } catch (IllegalArgumentException e) {
            return ILLEGAL_VALUE;
        }

    }

    private int getWinner(List<Integer> calculationResults) {
        // 페이지 계산 결과를 받아 우승자를 구한다.
        if (calculationResults.size() != 2) {
            return ILLEGAL_VALUE;
        }

        int firstPlayerResults = calculationResults.get(0);
        int secondPlayerResults = calculationResults.get(1);

        if (firstPlayerResults > secondPlayerResults) {
            return FIRST_PAGE_WIN;
        } else if (firstPlayerResults < secondPlayerResults) {
            return SECOND_PAGE_WIN;
        }

        return DRAW;
    }
}
