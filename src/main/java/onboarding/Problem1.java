package onboarding;

import java.util.List;

/**
 * 📚 기능 목록
 *
 * 1. 숫자의 합을 구하는 기능 : `getPageSum()`
 * 2. 숫자의 곱을 구하는 기능 : `getPageMultiple()`
 * 3. 점수를 비교하는 기능 : `getMaxScore()`
 * 4. 유저의 점수를 구하는 기능 : `getUserScore()`
 * 5. Solution
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    /**
     * 주어진 페이지 각 자리수의 합과 곱중 큰 값을 반환한다.
     * @param page 페이지
     * @return 합, 곱 중 큰 값을 반환한다.
     */
    private static int getMaxScore(Integer page) {
        return Math.max(getPageSum(page), getPageMultiple(page));
    }

    /**
     * 주어진 페이지의 각 자리수 합을 구한다.
     * @param page 페이지
     * @return 페이지의 각 자리수 합을 반환한다.
     */
    private static int getPageSum(Integer page) {
        String str = page.toString();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            result += str.charAt(i) - '0';
        }
        return result;
    }

    /**
     * 주어진 페이지의 각 자리수 곱을 구한다.
     * @param page 페이지
     * @return 페이지의 각 자리수 곱을 반환한다.
     */
    private static int getPageMultiple(Integer page) {
        String str = page.toString();
        int result = 1;
        for (int i = 0; i < str.length(); i++) {
            result *= str.charAt(i) - '0';
        }
        return result;
    }
}