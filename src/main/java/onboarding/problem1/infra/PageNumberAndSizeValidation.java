package onboarding.problem1.infra;

public class PageNumberAndSizeValidation {

    private static final Integer FIXED_SIZE = 2;

    public void checkedPageSize(Integer pobiSize, Integer crongSize) {
        if (!isPageSizeRange(pobiSize, crongSize)) {
            // 예외
            throw new IllegalArgumentException("펼친 페이지의 사이즈는 2 여야 합니다.");
        }
    }

    // 페이지 사이즈가 고정된 사이즈 2여야 한다.
    private static boolean isPageSizeRange(Integer pobiSize, Integer crongSize) {
        return FIXED_SIZE.equals(pobiSize) && FIXED_SIZE.equals(crongSize);
    }

    // 페이지 번호 검증
    public void checkedPageNumber(Integer leftPageNumber, Integer rightPageNumber) {
        if (!isPageNumberRange(leftPageNumber, rightPageNumber)) {
            // 예외
            throw new IllegalArgumentException("페이지 번호의 범위는 1 ~ 400 이여야 합니다.");
        }

        if (!isRightPageNumberOneBig(leftPageNumber, rightPageNumber)) {
            // 예외
            throw new IllegalArgumentException("오른쪽 페이지 번호가 왼쪽 페이지 번호보다 1이 커야 합니다.");
        }

        if (!(!isEven(leftPageNumber) && isEven(rightPageNumber))) {
            // 예외
            throw new IllegalArgumentException("왼쪽 페이지는 홀수고 오른쪽 페이지는 짝수여야 합니다.");
        }

        if (!(isStartPage(leftPageNumber) && isLastPage(rightPageNumber))) {
            // 예외
            throw new IllegalArgumentException("펼친 페이지가 시작면이 1이 아니여야 하고 마지막면이 400이 아니여야 합니다.");
        }

        if (!isBigRightPageNumber(leftPageNumber, rightPageNumber)) {
            // 예외
            throw new IllegalArgumentException("오른쪽 페이지가 왼쪽페이지 보다 커야 합니다.");
        }

    }

    // 페이지 번호는 1에서 400까지다
    private static boolean isPageNumberRange(Integer leftPageNumber, Integer rightPageNumber) {
        return isLeftPageNumberRange(leftPageNumber) && isRightPageNumberRange(rightPageNumber);
    }

    private static boolean isRightPageNumberRange(Integer rightPageNumber) {
        return rightPageNumber > 1 && rightPageNumber <= 400;
    }

    private static boolean isLeftPageNumberRange(Integer leftPageNumber) {
        return leftPageNumber >= 1 && leftPageNumber <= 399;
    }

    // 오른쪽 페이지가 왼쪽 페이지보다 1이 더 크다
    private static boolean isRightPageNumberOneBig(Integer leftPageNumber, Integer rightPageNumber) {
        return rightPageNumber - leftPageNumber == 1;
    }

    // 짝수 홀수 검증 기능
    private static boolean isEven(Integer pageNumber) {
        return pageNumber % 2 == 0;
    }

    // 시작 페이지가 1이 아니여야 한다.
    private boolean isStartPage(Integer startPage) {
        return startPage > 1;
    }

    // 마지막 페이지가 400 이 아니여야 한다.
    private boolean isLastPage(Integer lastPage) {
        return lastPage < 400;
    }

    // 오른쪽 페이지가 왼쪽 페이지보다 커야 한다.
    private static boolean isBigRightPageNumber(Integer leftPageNumber, Integer rightPageNumber) {
        return leftPageNumber < rightPageNumber;
    }
}
