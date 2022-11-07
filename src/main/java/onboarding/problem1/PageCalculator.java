package onboarding.problem1;

import onboarding.problem1.page.Player;

import java.util.List;
import java.util.stream.Collectors;

public class PageCalculator {

    public List<Integer> getResult(List<Player> playerList) {
        // page를 받아 계산 결과를 리턴한다. (0:firstPlayer, 1:secondPlayer)
        return playerList.stream()
                .map(this::getMaxValue)
                .collect(Collectors.toList());
    }

    private int getMaxValue(Player player) {
        // player의 pageList를 받아 값을 계산한다.
        return player.pages().stream()
                .mapToInt(this::calculatePage)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    private int calculatePage(Integer page) {
        char[] pageNums = String.valueOf(page).toCharArray();

        // 자릿수 별로 계산 수행
        int sum = 0;
        int multiplication = 1;
        for (char pageNum : pageNums) {
            sum += pageNum - '0';
            multiplication *= (pageNum - '0');
        }

        return Math.max(sum, multiplication);  // 덧셈, 곱셈 중 최대값 반환.
    }
}
