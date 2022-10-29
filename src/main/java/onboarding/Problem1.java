package onboarding;

import java.util.List;

class Problem1 {
    /**
     * 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱한 값 중 가장 큰 수 구하기
     * @param x
     * @return 가장 큰 값
     */
    private static int getMaxOfSumAndMulti(Integer x) {
        int remain = -1;
        int multiple = 1;
        int sum = 0;

        while (x > 0) {
            remain = x % 10;
            sum += remain;
            multiple *= remain;
            x = x / 10;
        }
        return Math.max(sum, multiple);
    }

    /**
     * 왼쪽 페이지 번호의 가장 큰 수와 오른쪽 페이지 번호의 가장 큰 수 중 가장 큰 수 구하기
     * @param list
     * @return 가장 큰 값
     */
    private static int getMax(List<Integer> list) {
        int leftMax = getMaxOfSumAndMulti(list.get(0));
        int rightMax = getMaxOfSumAndMulti(list.get(1));

        return Math.max(leftMax, rightMax);
    }

    /**
     * 포비와 크롱의 리스트 길이가 2가 아니면 예외
     * @param list
     * @return 리스트 길이가 2가 아니면 true / 맞으면 false
     */
    private static Boolean isPageListSize2(List<Integer> list) {
        if (list.size() != 2) {
            return true;
        }
        return false;
    }

    /**
     * 페이지 번호가 연속되지 않을 때 예외
     * @param list
     * @return 연속되지 않으면 true / 연속되면 false
     */
    private static Boolean isPageContinu(List<Integer> list) {
        if(list.get(1) - list.get(0) != 1)
            return true;
        return false;
    }

}