package onboarding;

import java.util.List;

/**
 * 기능 1: 올바른 페이지 수가 입력되었는가 확인
 * 기능 2: 각각 개별로 최대로 얻은 점수를 최고 점수로 구하기
 * 기능 3: 두 명의 점수를 비교하여 승패 가르기
 */
class Problem1 {

    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int EXCEPTION = -1;

    public static boolean isEvenPage(int pageNumber) {
        return pageNumber % 2 == 0;
    }

    private static boolean validatePage(List<Integer> pages) {

        int left = pages.get(0), right = pages.get(1);

        if (left < 1 || right > 400) {
            return false;
        }

        if (isEvenPage(left) || !isEvenPage(right)) {
            return false;
        }

        if (left > right) {
            return false;
        }

        if (Math.abs(left - right) != 1) {
            return false;
        }
        return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}