package onboarding.problem1;

import java.util.List;

import static onboarding.problem1.GameResults.*;
import static onboarding.problem1.PageValidator.*;

public class BookGame {

    private PageCalculator pageCalculator;

    private BookGame() {
    }

    public BookGame(PageCalculator pageCalculator) {
        this.pageCalculator = pageCalculator;
    }

    public int doBookGame(List<Integer> firstPages, List<Integer> secondPages) {
        // 게임을 수행하는 메서드
        List<List<Integer>> pagesList = List.of(firstPages, secondPages);

        if (!isValidPage(pagesList)) {
            return ILLEGAL_VALUE;
        }

        return getWinner(pageCalculator.getResult(pagesList));
    }

    private int getWinner(List<Integer> calculationResults) {
        // 페이지 계산 결과를 받아 우승자를 구한다.
        if (calculationResults.size() != 2) {
            return ILLEGAL_VALUE;
        }

        Integer firstResults = calculationResults.get(0);
        Integer secondResults = calculationResults.get(1);

        if (firstResults > secondResults) {
            return FIRST_PAGE_WIN;
        } else if (firstResults < secondResults) {
            return SECOND_PAGE_WIN;
        } else {
            return DRAW;
        }
    }
}
