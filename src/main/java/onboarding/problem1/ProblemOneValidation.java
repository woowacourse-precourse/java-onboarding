package onboarding.problem1;

public class ProblemOneValidation {

    private Integer fixedListSize;
    private Integer leftPageNumber;
    private Integer rightPageNumber;

    public void settingFixedPageSize(Integer fixedListSize) {
        this.fixedListSize = fixedListSize;
    }

    public void settingPageNumber(Integer leftPageNumber, Integer rightPageNumber) {
        this.leftPageNumber = leftPageNumber;
        this.rightPageNumber = rightPageNumber;
    }

    public boolean isPageSize(Integer pobiSize, Integer crongSize) {
        return this.fixedListSize == pobiSize && this.fixedListSize == crongSize;
    }

    // 페이지 번호 검증
    public boolean isPageNumberValidation() {
        if (isLeftPageNumber()) {
            return true;
        }

        if (isRightPageNumber()) {
            return true;
        }

        return false;
    }

    private boolean isLeftPageNumber() {
        return this.leftPageNumber % 2 != 0 && this.leftPageNumber < this.rightPageNumber && isPageNumberCommonValidation() && isStartPage();
    }

    private boolean isStartPage() {
        return this.leftPageNumber != 1;
    }

    private boolean isLastPage() {
        return this.rightPageNumber != 400;
    }

    private boolean isRightPageNumber() {
        return rightPageNumber % 2 == 0 && rightPageNumber > leftPageNumber && isPageNumberCommonValidation() && isLastPage();
    }

    private boolean isPageNumberCommonValidation() {
        return this.leftPageNumber + 1 == this.rightPageNumber && leftPageNumber >= 1 && leftPageNumber <= 399 && rightPageNumber > 1 && rightPageNumber <= 400;
    }

}
