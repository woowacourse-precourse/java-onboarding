package onboarding;

import java.util.List;

/**
 * 기능 목록
 * 1. 예외 체크
 * 2. 각 자리수의 합과 곱 구하는 함수
 * 3. 한 페이지에서 높은 점수를 구하는 함수
 * 4. 두 사람의 점수를 비교하여 결과를 반환
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkException(pobi) || checkException(crong)) {
            return -1;
        }
        int pobiScore = Math.max(pageMax(pobi.get(0)), pageMax(pobi.get(1)));
        int crongScore = Math.max(pageMax(crong.get(0)), pageMax(crong.get(1)));
        int answer = pobiScore > crongScore ? 1 : pobiScore < crongScore ? 2 : 0;

        return answer;
    }

    /**
     * 페이지 쌍의 예외를 체크한다.
     * 
     * @param pages 펼친 페이지 쌍
     * @return 예외가 있다면 true, 없으면 false 반환
     */
    private static boolean checkException(List<Integer> pages) {
        Integer left = pages.get(0);
        Integer right = pages.get(1);
        // null check
        if (left == null || right == null)
            return true;
        // range check
        if (left >= right || left < 0 || right > 400)
            return true;
        // odd check
        if (left % 2 != 1)
            return true;
        // continuous check
        if (right - left != 1)
            return true;

        return false;
    }

    /**
     * 한 페이지 자리수의 합과 곱 중 큰 수를 구합니다.
     * 
     * @param pageNum
     * @return 자리수의 합과 곱 중 큰 수
     */
    private static int pageMax(int pageNum) {
        int sum = eachSum(pageNum);
        int multiple = eachMultiplication(pageNum);
        return Math.max(sum, multiple);
    }

    /**
     * 각 자리수의 합을 구합니다.
     * 
     * @param num
     * @return 각 자리수의 합
     */
    private static int eachSum(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    /**
     * 각 자리수의 곱을 구합니다.
     * 
     * @param num
     * @return 각 자리수의 곱
     */
    private static int eachMultiplication(int num) {
        int result = 1;
        while (num > 0) {
            result *= num % 10;
            num /= 10;
        }
        return result;
    }
}