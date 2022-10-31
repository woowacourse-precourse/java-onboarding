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
        int answer = -1;

        if (!isExcept(pobi) && !isExcept(crong)) {
            int pobiValue = getMaxValue(pobi);
            int crongValue = getMaxValue(crong);

            answer = getAnswer(pobiValue, crongValue);
        }

        return answer;
    }

    /**
     * 페이지 번호에 예외가 있는 경우 true를 반환합니다.
     *
     * @param pages [왼쪽 페이지 번호, 오른쪽 페이지 번호]
     * @return 예외가 있는 경우 true, 그렇지 않으면 false 반환
     */
    static boolean isExcept(List<Integer> pages) {
        int left = pages.get(0);
        int right = pages.get(1);

        // 페이지 범위(1~400)를 넘어가는지 검사
        // 시작 면이나 마지막 면을 펴는 것은 임의의 면이라 할 수 없으므로 1페이지와 400 페이지 제외
        if (left <= 1 || right >= 400) {
            return true;
        }
        // 왼쪽과 오른쪽 페이지 번호가 연속적인지 검사
        // 왼쪽 페이지가 홀수인지 검사 (오른쪽 페이지는 짝수가 되므로 검사하지 않아도 됨)
        else if (left + 1 != right || left % 2 != 1) {
            return true;
        }

        return false;
    }

    /**
     * 페이지 번호의 각 자리 합과 곱을 계산하여 최댓값을 반환합니다.
     *
     * @param page 페이지 번호
     * @return 페이지 번호의 각 자리 합과 곱 중 최댓값
     */
    static int calValue(int page) {
        int sum = 0;
        int mul = 1;

        while (page > 0) {
            sum += page % 10;
            mul *= page % 10;
            page /= 10;
        }

        return Math.max(sum, mul);
    }

    /**
     * 왼쪽과 오른쪽 페이지 번호의 계산 결과 중 최댓값을 반환합니다.
     *
     * @param pages [왼쪽 페이지 번호, 오른쪽 페이지 번호]
     * @return 왼쪽과 오른쪽 페이지 번호의 계산 결과 중 최댓값 반환
     * @see Problem1#calValue(int)
     */
    static int getMaxValue(List<Integer> pages) {
        int leftValue = calValue(pages.get(0));
        int rightValue = calValue(pages.get(1));

        return Math.max(leftValue, rightValue);
    }

    /**
     * 포비와 크롱의 게임 결과를 반환합니다.
     *
     * @param pobiValue  포비의 최댓값
     * @param crongValue 크롱의 최댓값
     * @return 무승부일 경우 0, 포비가 이길 경우 1, 크롱이 이길 경우 2 반환
     */
    static int getAnswer(int pobiValue, int crongValue) {
        if (pobiValue == crongValue) return 0;
        return pobiValue > crongValue ? 1 : 2;
    }
}