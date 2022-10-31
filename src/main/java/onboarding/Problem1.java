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
        Page pobiPage = new Page(pobi);
        Page crongPage = new Page(crong);
        if (pobiPage.isInvalidPages() || crongPage.isInvalidPages()) {
            return RESULT_EXCEPTION;
        }

        int pobiScore = pobiPage.calculatePages();
        int crongScore = crongPage.calculatePages();

        if (crongScore > pobiScore) {
            return RESULT_CRONG;
        }
        if (pobiScore > crongScore) {
            return RESULT_POBI;
        }
        return RESULT_DRAW;
    }





}