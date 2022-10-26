package onboarding.promblem1;

import java.util.List;

public class Pages implements Comparable<Pages> {
    List<PageNumber> pageNumbers;

    public Pages(List<PageNumber> pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public int getMax() {
        return pageNumbers.stream().map(PageNumber::getMax).max(Integer::compareTo).orElse(0);
    }

    @Override
    public int compareTo(Pages otherPage) {
        if (isNotContinuous()) {
            return -1;
        }
        if (this.getMax() > otherPage.getMax()) {
            return 1;
        } else if (this.getMax() < otherPage.getMax()) {
            return 2;
        }
        return 0;
    }

    private boolean isNotContinuous() {
        return getSubtractPage() != 1;
    }

    private Integer getSubtractPage() {
        return pageNumbers.stream().map(PageNumber::getPage).reduce(0, (a, b) -> b - a);
    }


}
