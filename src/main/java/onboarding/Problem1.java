package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    /**
     * 1-3 에러체크
     * @param list
     * @return 페이지의 범위 및 페이지의 길이 검사 후 옳은 리스트라면 fasle 리턴 아니면 true 리턴
     */
    private static boolean validation(List<Integer> list) {
        return !(checkValidatePage(list.get(0), list.get(1)) &&
            checkValidateRange(list.get(0), list.get(1)));
    }

    /**
     * 1-2 왼쪽 페이지와 오른쪽 페이지의 범위 검사
     * @param leftPage
     * @param rightPage
     * @return 옳은 페이지 범위면 true 틀리면 false 리턴
     */
    private static boolean checkValidateRange(int leftPage, int rightPage) {
        return (leftPage <= PAGE_MAX_RANGE && rightPage <= PAGE_MAX_RANGE) &&
            (leftPage >= PAGE_MIN_RANGE && rightPage >= PAGE_MIN_RANGE);
    }

    /**
     * 1-1 왼쪽 페이지와 오른쪽 페이지의 길이 검사
     * @param leftPage
     * @param rightPage
     * @return 옳은 페이지 길이면 true 틀리면 false 리턴
     */
    private static boolean checkValidatePage(int leftPage, int rightPage) {
        return leftPage % 2 == 1 && rightPage % 2 == 0 && leftPage + 1 == rightPage;
    }
    /**
     * 2-3 합과 곱중 큰 값 연산
     * @param plusResult
     * @param multiplyResult
     * @return 합과 곱중 큰 값 리턴
     */
    private static int getMaxScore(int plusResult, int multiplyResult) {
        return Integer.max(plusResult, multiplyResult);
    }

    /**
     * 2-2 주어진 리스트의 자릿수 별 곱 연산
     * @param value
     * @return 주어진 리스트의 자릿수 별 곱 연산값 리턴
     */
    private static int getMultiplyResult(int value) {
        int multiplyResult = 1;
        while (value != 0) {
            multiplyResult *= value % 10;
            value /= 10;
        }
        return multiplyResult;
    }

    /**
     * 2-1 주어진 리스트의 자릿수 합 곱 연산
     * @param value
     * @return 주어진 리스트의 자릿수 별 합 연산값 리턴
     */
    private static int getPlusResult(int value) {
        int plusResult = 0;
        while (value != 0) {
            plusResult += value % 10;
            value /= 10;
        }
        return plusResult;
    }
}