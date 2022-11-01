package onboarding.problem1;

import java.util.Comparator;
import java.util.List;

public class Pages {
    List<Page> pageList;

    public Pages(List<Page> pageList) {
        validatePageNumberGap(pageList);
        validateLeftPageNumberIsOdd(pageList);
        this.pageList = pageList;
    }

    public void validatePageNumberGap(List<Page> pageList) {
        if (pageList.get(1).getPageNumber() - pageList.get(0).getPageNumber() != 1) {
            throw new IllegalArgumentException();
        }
    }

    public void validateLeftPageNumberIsOdd(List<Page> pageList) {
        if (pageList.get(0).getPageNumber() % 2 == 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getMaxScore() {
        return Math.max(getMaxScoreBySum(), getMaxScoreByProduct());
    }

    public int getMaxScoreBySum() {
        return pageList.stream()
                .map(page -> page.getSumOfPageDigits())
                .max(Comparator.comparing(Integer::intValue))
                .get();
    }

    public int getMaxScoreByProduct() {
        return pageList.stream()
                .map(page -> page.getProductOfPageDigits())
                .max(Comparator.comparing(Integer::intValue))
                .get();
    }
}
