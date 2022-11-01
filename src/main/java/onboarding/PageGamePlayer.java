package onboarding;

import java.util.List;

public class PageGamePlayer {
    private int leftPage, rightPage;

    public PageGamePlayer(List<Integer> list) {
        if (validPageList(list)) {
            this.leftPage = list.get(0);
            this.rightPage = list.get(1);
        }
    }

    private boolean validPageList(List<Integer> pages) {
        if (pages.size() != 2)
            return false;

        return true;
    }

    public boolean isValid() {
        if (leftPage <= 0 || rightPage > 400)
            return false;

        if (rightPage - leftPage != 1)
            return false;

        if (leftPage % 2 != 1)
            return false;

        if (rightPage % 2 != 0)
            return false;

        return true;
    }

    public int maxPageNum() {
        return Math.max(
                Math.max(EachDigitCalculator.add(leftPage),
                        EachDigitCalculator.add(leftPage)),
                Math.max(EachDigitCalculator.multiply(rightPage),
                        EachDigitCalculator.multiply(rightPage)));
    }
}
