package onboarding.validator;

import java.util.List;

public class PageNumberValidator {

    public static final int FIRST_PAGE_NUMBER = 1;
    public static final int LAST_PAGE_NUMBER = 400;
    public static final String PAGE_NUMBER_CONTAIN_BOUNDARY_PAGE_ERROR = "[ERROR] 책의 시작 면이나 마지막 면은 펼칠 수 없습니다.";
    public static final String PAGE_NUMBER_NOT_SEQUENTIAL_ERROR = "[ERROR] 페이지 번호는 연속된 숫자여야 합니다.";

    public static void isValidPageNumbers(List<Integer> pageNumbers) {
        isSequentialPageNumber(pageNumbers);
        containBoundaryPage(pageNumbers);
    }

    private static void isSequentialPageNumber(List<Integer> pageNumbers) {
        if (isNotSequentialPageNumber(pageNumbers)) {
            throw new IllegalArgumentException(PAGE_NUMBER_NOT_SEQUENTIAL_ERROR);
        }
    }

    private static void containBoundaryPage(List<Integer> pageNumbers) {
        if (isFirstPage(pageNumbers) || isLastPage(pageNumbers)) {
            throw new IllegalArgumentException(PAGE_NUMBER_CONTAIN_BOUNDARY_PAGE_ERROR);
        }
    }

    private static boolean isNotSequentialPageNumber(List<Integer> pageNumbers) {
        return pageNumbers.get(1) - pageNumbers.get(0) != 1;
    }

    private static boolean isFirstPage(List<Integer> pageNumbers) {
        return pageNumbers.contains(FIRST_PAGE_NUMBER);
    }

    private static boolean isLastPage(List<Integer> pageNumbers) {
        return pageNumbers.contains(LAST_PAGE_NUMBER);
    }
}
