package onboarding.problem1;

import java.util.List;

import static onboarding.problem1.PageValidation.*;

public class BookGame {

    private static final int FIRST_PAGE_WIN = 1;
    private static final int SECOND_PAGE_WIN = 2;
    private static final int DRAW = 0;
    private static final int ILLEGAL_PAGES = -1;

    public static int doBookGame(List<Integer> firstPages, List<Integer> secondPages) {
        // 게임을 수행하는 메서드
        if (!isValidPage(List.of(firstPages, secondPages))) {
            return ILLEGAL_PAGES;
        }

        return 1;
    }

    private static int getWinner(int firstPageResult, int secondPageResult) {
        // 페이지 계산 결과를 받아 우승자를 구한다.

        return -1;
    }
}
