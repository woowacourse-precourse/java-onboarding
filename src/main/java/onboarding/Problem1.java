package onboarding;

import java.util.List;
import java.util.Map;

class Problem1 {

    /**
     * 1. 책을 임의로 펼친다.
     * 2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
     * 3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
     * 4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
     * 5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
     * 6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
     * @param pobi 포비가 펼친 페이지
     * @param crong 크롱이 펼친 페이지
     * @return 포비가 이기면 1, 크롱이 이기면 2, 무승부는 0, 예외는 -1
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!isValid(pobi) || !isValid(crong)) return -1;

        int pobiNum = getMax(pobi);
        int crongNum = getMax(crong);
        if (pobiNum > crongNum) return 1;
        if (crongNum > pobiNum) return 2;
        return 0;
    }

    /**
     *
     * @param page 펼친 페이지
     * @return 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수일 경우 True, 아닐 경우 False, 페이지가 1미만, 400초과일 경우 False
     */
    public static boolean isValid(List<Integer> page) {
        int left = page.get(0);
        int right = page.get(1);
        // 페이지 범위 검사
        if (left < 1 || left > 400) return false;
        // 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수인지 검사
        if (left % 2 != 1 || right % 2 != 0) return false;
        // 연속된 페이지인지 검사
        if (right - left != 1) return  false;
        return true;
    }
    /**
     *
     * @param input 계산 결과
     * @return 계산 결과 중 최댓값
     */
    static int getMax(List<Integer> input) {
        int left = input.get(0);
        int right = input.get(1);

        int leftResult = getSumAndMul(left);
        int rightResult = getSumAndMul(right);

        if (leftResult > rightResult) return leftResult;
        return rightResult;
    }
    public static int getSumAndMul(int page) {
        int sum = 0;
        int mul = 1;

        while(page > 0) {
            int digit = page % 10;
            sum += digit;
            mul *= digit;
            page /= 10;
        }
        if (sum > mul) return sum;
        return mul;
    }

}