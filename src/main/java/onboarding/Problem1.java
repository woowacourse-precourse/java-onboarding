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

}