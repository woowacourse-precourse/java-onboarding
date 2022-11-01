package onboarding;

import java.util.List;

/**
 * Problem 1
 *
 * 기능 요구 사항
 * 1, 책을 임의로 펼친다.  (Test에서 존재)
 * 2. 페이지 번호의 각 자리 숫자를 모두 더하거나 모두 곱해 가장 큰 수를 구한다.
 * 3. 점수를 비교해 가장 높은 사람이 게임의 승자
 *
 * 제한 사항
 * 1. 포비와 크롱의 길이는 2
 * 2. 포비와 크롱에는 왼쪽 페이지 번호, 오른쪽 페이지 번호가 순서대로 들어있다.
 */
class Problem1 {
    /**
     *
     * @param pobi
     * @param crong
     * @return 1 2 0 -1 (포비가 승리 / 크롱의 승리 / 무승부 / 예외사항 )
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (Problem1.isPageError(pobi) || Problem1.isPageError(crong)) {
            return -1;
        }

        int pobiResult = Problem1.calcOwnMostNum(pobi);
        int crongResult = Problem1.calcOwnMostNum(crong);

        answer = compTwoValue(pobiResult, crongResult);
        return answer;
    }

    /**
     * 자신의 최대 점수 구하는 함수
     * @param pages
     * @return 최대 점수
     */
    public static int calcOwnMostNum(List<Integer> pages) {
        int max = 0;
        for (Integer page : pages) {
            int plus = Problem1.plusEachIndex(page);
            int mul = Problem1.mulEachIndex(page);
            int tempMax = plus > mul ? plus : mul;

            if (max < tempMax) {
                max = tempMax;
            }
        }
        return max;
    }

    /**
     * 각 자리 더하는 함수
     * @param page 페이지 값
     * @return 각 자리 더한 값 or -1 ( 예외 사항 )
     */
    public static int plusEachIndex(int page){
        int ret = 0;
        int tempPage = page;

        while (tempPage != 0) {
            ret += (tempPage % 10);
            tempPage /= 10;
        }

        return ret;
    }

    /**
     * 각 자리 곱하는 함수
     *
     * @param page 페이지 값
     * @return 각 자리 곱한 값
     */
    public static int mulEachIndex(int page){
        int ret = 1;
        int tempPage = page;

        while (tempPage != 0) {
            ret *= (tempPage % 10);
            tempPage /= 10;
        }

        return ret;
    }

    /**
     * 책 페이지가 범위 밖이나 있을 수 없는 값인지 확인
     * @param pages
     * @return 범위 밖이면 true, 아니면 false
     */
    public static boolean isPageError(List<Integer> pages){
        if ((pages.get(0) % 2 != 1) || (pages.get(1) % 2 != 0)){
            return true;
        }

        int gap = pages.get(1) - pages.get(0);
        if (gap != 1) {
            return true;
        }
        return (pages.get(1) > 400 || pages.get(0) <= 0);
    }

    /**
     * 두 값을 비교하는 함수
     * @param value1
     * @param value2
     * @return 왼쪽이 크면 1 / 오른쪽이 크면 2 / 같으면 0
     */
    public static int compTwoValue(int value1, int value2) {
        if (value1 > value2) {
            return 1;
        } else if (value1 < value2) {
            return 2;
        }
        return 0;
    }
}