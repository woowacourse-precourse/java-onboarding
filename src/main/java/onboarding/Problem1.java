package onboarding;

import java.util.List;

/* 기능 목록
 * 1. 예외 처리 기능
 *   - 페이지 범위는 1 ~ 400
 *   - 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수
 *   - 왼쪽과 오른쪽 페이지는 연속적 ([99, 102] X)
 *   - 시작 면이나 마지막 면은 펼치지 않음
 * 2. 페이지의 각 자리 합과 곱을 계산하여 최댓값을 반환하는 기능
 * 3. 페이지를 비교하여 결과를 반환하는 기능
 * */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        Problem1 problem1 = new Problem1();

        if (problem1.isExcept(pobi) || problem1.isExcept(crong)) {
            answer = -1;
        }

        return answer;
    }

    /**
     * 페이지 번호에 예외가 있는 경우 true를 반환합니다.
     *
     * @param pages [왼쪽 페이지 번호, 오른쪽 페이지 번호]
     * @return 예외가 있는 경우 true, 그렇지 않으면 false 반환*/
    boolean isExcept(List<Integer> pages) {
        int left = pages.get(0);
        int right = pages.get(1);

        if (left <= 1 || right >= 400) {
            return true;
        } else if (left % 2 != 1 || right % 2 != 0) {
            return true;
        } else if (left + 1 != right) {
            return true;
        }

        return false;
    }
}