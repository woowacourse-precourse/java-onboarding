package onboarding.problem1;

import java.util.List;

class PageGame {
    private PageOperator pageOperator;
    private List<Integer> pobis;
    private List<Integer> crongs;

    private boolean isFaultPageData(List<Integer> pageData) {
        if(pageData.get(0) < 2 || pageData.get(1) < 3)return true;
        if(pageData.get(0)>398 || pageData.get(1) > 399)return true;
        if (pageData.get(0) + 1 != pageData.get(1)) return true;
        if (pageData.get(1) == 0) return true;
        return false;
    }

    public PageGame(List<Integer> pobi, List<Integer> crong) {
        pageOperator = new PageOperator();
        if(isFaultPageData(pobi) || isFaultPageData(crong))throw new RuntimeException();
        pobis = pobi;
        crongs = crong;
    }

    public Integer start() {
        Integer pobi = pageOperator.getMaxPageNumber(pobis);
        Integer crong = pageOperator.getMaxPageNumber(crongs);
        if (pobi > crong) return 1;
        if (pobi < crong) return 2;
        if (pobi == crong) return 0;
        throw new RuntimeException();
    }
}
