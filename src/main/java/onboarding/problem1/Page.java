package onboarding.problem1;

import java.util.List;

public class Page {
    private final int LEFT_PAGE_INDEX = 0;
    private final int RIGHT_PAGE_INDEX = 1;
    private final int MIN_PAGE = 1;
    private final int MAX_PAGE = 400;

    private List<Integer> pages;

    public Page(List<Integer> pages) {
        this.pages = pages;
    }

    /* 두 페이지의 유효성을 검사한다.
     1. Null 체크
     2. 페이지 범위(1~400) 및 6번 규칙 체크
     3. 왼쪽 페이지 홀수, 오른쪽 페이지 짝수 체크
     4. 페이지 연속성 체크
     */
    public boolean isInvalidPages() {
        Integer leftPage = pages.get(LEFT_PAGE_INDEX);
        Integer rightPage = pages.get(RIGHT_PAGE_INDEX);
        if (leftPage == null || rightPage == null) {
            return true;
        }
        if (leftPage <= MIN_PAGE || rightPage >= MAX_PAGE) {
            return true;
        }
        if (leftPage % 2 == 0 || rightPage % 2 == 1) {
            return true;
        }
        if (leftPage + 1 != rightPage) {
            return true;
        }
        return false;
    }

    // 페이지의 각 자릿수를 더한 결과를 리턴한다.
    private int calcAddPageNumber(int pageNumber) {
        int result = 0;
        while (pageNumber > 0) {
            result += pageNumber % 10;
            pageNumber /= 10;
        }
        return result;
    }

    // 페이지의 각 자릿수를 곱한 결과를 리턴한다.
    private int calcMulPageNumber(int pageNumber) {
        int result = 1;
        while (pageNumber > 0) {
            result *= pageNumber % 10;
            pageNumber /= 10;
        }
        return result;
    }

    // 양 페이지의 각 자릿수를 더한 수, 곱한 수 중에서 가장 큰 수를 리턴한다.
    public int calculatePages() {
        int leftPage = pages.get(LEFT_PAGE_INDEX);
        int leftPageAddNumber = calcAddPageNumber(leftPage);
        int leftPageMulNumber = calcMulPageNumber(leftPage);
        int leftPageMaxNumber = Math.max(leftPageAddNumber, leftPageMulNumber);

        int rightPage = pages.get(RIGHT_PAGE_INDEX);
        int rightPageAddNumber = calcAddPageNumber(rightPage);
        int rightPageMulNumber = calcMulPageNumber(rightPage);
        int rightPageMaxNumber = Math.max(rightPageAddNumber, rightPageMulNumber);

        return Math.max(leftPageMaxNumber, rightPageMaxNumber);
    }
}
