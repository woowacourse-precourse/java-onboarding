package onboarding;

import java.util.List;

public class PageGamePlayer {
    private int leftPage, rightPage;

    public PageGamePlayer(List<Integer> list) {
        validPageList(list);
        this.leftPage = list.get(0);
        this.rightPage = list.get(1);
        validPageNum();
    }

    private void validPageList(List<Integer> pages){
        if (pages.size() != 2)
            throw new IllegalArgumentException("2개의 페이지를 입력해주세요.");
    }

    private void validPageNum(){
        if (leftPage <= 0 || rightPage > 400)
            throw new IllegalArgumentException("페이지 범위를 벗어났습니다.");

        if (rightPage - leftPage != 1)
            throw new IllegalArgumentException("페이지 번호가 연속적이지 않습니다.");

        if (leftPage % 2 != 1)
            throw new IllegalArgumentException("왼쪽에는 짝수 페이지 번호가 와야합니다.");

        if (rightPage % 2 != 0)
            throw new IllegalArgumentException("오른쪽에는 홀수 페이지 번호가 와야합니다.");
    }

    public int maxPageNum() {
        return Math.max(
                Math.max(EachDigitCalculator.add(leftPage),
                        EachDigitCalculator.add(leftPage)),
                Math.max(EachDigitCalculator.multiply(rightPage),
                        EachDigitCalculator.multiply(rightPage)));
    }
}
