package problem1;

import java.util.List;
import java.util.Objects;

public class Player {

    private static final String ERR_PAGES_SIZE = "페이지는 2개만 입력하시오.";
    private static final String ERR_PAGES_ORDER = "좌우 페이지 순서대로 입력하시오.";
    private final List<Page> pages;

    public Player(List<Page> pages) {
        this.pages = Objects.requireNonNull(pages);
        validatePages();
    }

    private void validatePages() {
        validatePagesSize();
        validatePagesOrder();
    }

    private void validatePagesSize() {
        if (pages.size() != 2) throw new IllegalStateException(ERR_PAGES_SIZE);
    }

    private void validatePagesOrder() {
        Page firstPage = pages.get(0), secondPage = pages.get(1);
        if (!firstPage.isOdd() || firstPage.compareTo(secondPage) != -1)
            throw new IllegalArgumentException(ERR_PAGES_ORDER);
    }

    public BattleResult battleWith(Player other) {
        int myScore = getScore(this.pages);
        int otherScore = getScore(other.pages);

        if (myScore > otherScore)
            return BattleResult.WIN;
        if (myScore == otherScore)
            return BattleResult.DRAW;
        if (myScore < otherScore)
            return BattleResult.LOSE;

        return null;
    }

    private int getScore(List<Page> pages) {
        return Math.max(pages.get(0).getScore(), pages.get(1).getScore());
    }
}
