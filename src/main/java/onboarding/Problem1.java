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
        int pobiScore = getUserScore(pobi);
        int crongScore = getUserScore(crong);

        // 예외 발생
        if(pobiScore == -1 || crongScore == -1) {
            return -1;
        }

        if(pobiScore > crongScore) {
            return 1;
        }

        if(pobiScore < crongScore) {
            return 2;
        }

        if(pobiScore == crongScore) {
            return 0;
        }

        return -1;
    }

    /**
     * 사용자의 점수를 구한다.
     * 예외 발생 시 -1을 반환한다.
     * @param person 유저 List
     * @return 유저의 점수를 반환한다.
     */
    private static int getUserScore(List<Integer> person) {
        Integer leftPage = person.get(0);
        Integer rightPage = person.get(1);

        // 책은 펼쳤을 때 연속된 수가 나와야한다.
        // 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수번호다.
        if((rightPage - leftPage) != 1 || (rightPage % 2) != 0 || (leftPage % 2) != 1) {
            return -1;
        }

        return Math.max(getMaxScore(leftPage), getMaxScore(rightPage));
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