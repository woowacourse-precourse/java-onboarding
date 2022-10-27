package onboarding;

import java.util.List;

/**
 * 기능 목록
 * 1. 입력값이 유효한 지 검사하는 함수
 * 2. 페이지 번호의 각 자리 숫자를 연산 해 가장 큰 수를 구하는 함수
 * 3. 본인의 점수(2번의 결과값들 중 가장 큰 수)를 구하는 함수
 */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!checkValidation(pobi) || !checkValidation(crong)) {
            return -1;
        }
        return 1;
    }

    /**
     * 리스트가 유효한 지 검사하는 함수
     *
     * @param pages
     * @return true if list is validate
     */
    private static boolean checkValidation(List<Integer> pages) {
        if (pages == null || pages.size() != 2) {
            return false;
        }

        final int leftPage = pages.get(0);
        final int rightPage = pages.get(1);

        if (leftPage + 1 != rightPage) {
            return false;
        }

        if (leftPage % 2 != 0 || rightPage % 2 > 0) {
            return false;
        }

        if (leftPage <= 0 || rightPage >= 400) {
            return false;
        }

        return true;
    }
}