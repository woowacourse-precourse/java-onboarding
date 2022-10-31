package onboarding;

import onboarding.problem1.Page;

import java.util.List;

class Problem1 {
    private static final int RESULT_POBI = 1;
    private static final int RESULT_CRONG = 2;
    private static final int RESULT_DRAW = 0;
    private static final int RESULT_EXCEPTION = -1;


    /*
    기능 목록
    1. 페이지 예외 검사 기능
    2. 페이지 각 자리 숫자 모두 더하는 기능
    3. 페이지 각 자리 숫자 모두 곱하는 기능
    4. 페이지에서 가장 큰 점수 계산 기능
    5. 점수 비교해서 승자 결정 기능
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isInvalidPages(pobi) || isInvalidPages(crong)) {
            return RESULT_EXCEPTION;
        }

        int pobiNumber = calculatePages(pobi);
        int crongNumber = calculatePages(crong);

        if (crongNumber > pobiNumber) {
            return RESULT_CRONG;
        }
        if (pobiNumber > crongNumber) {
            return RESULT_POBI;
        }
        return RESULT_DRAW;
    }


    /* 두 페이지의 유효성을 검사한다.
     1. Null 체크
     2. 페이지 범위(1~400) 및 6번 규칙 체크
     3. 왼쪽 페이지 홀수, 오른쪽 페이지 짝수 체크
     4. 페이지 연속성 체크
     */
    private static boolean isInvalidPages(List<Integer> pages) {
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
    private static int calcAddPageNumber(int pageNumber) {
        int result = 0;
        while (pageNumber > 0) {
            result += pageNumber % 10;
            pageNumber /= 10;
        }
        return result;
    }

    // 페이지의 각 자릿수를 곱한 결과를 리턴한다.
    private static int calcMulPageNumber(int pageNumber) {
        int result = 1;
        while (pageNumber > 0) {
            result *= pageNumber % 10;
            pageNumber /= 10;
        }
        return result;
    }

    // 양 페이지의 각 자릿수를 더한 수, 곱한 수 중에서 가장 큰 수를 리턴한다.
    private static int calculatePages(List<Integer> pages) {
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