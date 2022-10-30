package onboarding.problem1;

import java.util.List;

class PageGame {
    PageOperator pageOperator;
    List<Integer>[] pageDatas = new List[2];

    private boolean isFaultPageData(List<Integer> pageData) {
        if (pageData.get(0) + 1 != pageData.get(1)) return true;
        if (pageData.get(1) == 0) return true;
        return false;
    }

    public PageGame(List<Integer> pobi, List<Integer> crong) {
        pageOperator = new PageOperator();
        pageDatas[0] = pobi;
        pageDatas[1] = crong;
    }

    public Integer start() {
        for (var pageData : pageDatas) {
            if (isFaultPageData(pageData)) throw new RuntimeException();
        }
        Integer pobi = pageOperator.getMaxPageNumber(pageDatas[0]);
        Integer crong = pageOperator.getMaxPageNumber(pageDatas[1]);
        if (pobi > crong) return 1;
        if (pobi < crong) return 2;
        if (pobi == crong) return 0;
        throw new RuntimeException();
    }
}
