package onboarding;

import java.util.List;

public class PageGamePlayer {
    private int leftPageNum, rightPageNum;

    public PageGamePlayer(List<Integer> list) {
        this.leftPageNum = list.get(0);
        this.rightPageNum = list.get(1);
    }

    public int maxPageNum() {
        return Math.max(
                Math.max(EachDigitCalculator.add(leftPageNum), EachDigitCalculator.add(leftPageNum)),
                Math.max(EachDigitCalculator.multiply(leftPageNum), EachDigitCalculator.multiply(rightPageNum)));
    }
}
