package onboarding.problem1;

import java.util.List;

public abstract class Page {
    private PageNumber pageNumber;

    public Page(final Integer number) {
        this.pageNumber = new PageNumber(number);
    }

    public Integer sum() {
        return pageNumber.sum();
    }

    public Integer multiple() {
        return pageNumber.multiple();
    }

}
