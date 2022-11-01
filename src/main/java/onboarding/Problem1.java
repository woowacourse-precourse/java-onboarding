package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (exceptionCase(pobi) || exceptionCase(crong)) {
            return -1;
        }

        return compareNum(maxSum(pobi), maxSum(crong));
    }

    private static boolean exceptionCase(List<Integer> pages) {

        final int START_PAGE = 1;
        final int END_PAGE = 400;

        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        // 페이지에 첫번째 또는 마지막 페이지가 포함된 경우
        if (pages.contains(START_PAGE) || pages.contains(END_PAGE)) {
            return true;
        }

        // 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수가 아닌 경우
        if (leftPage % 2 != 1 || rightPage % 2 != 0) {
            return true;
        }

        // 페이지의 범위가 1미만 400초과일 경우
        if (leftPage < START_PAGE || rightPage > END_PAGE) {
            return true;
        }

        return false;
    }

    private static int compareNum(Integer pobi, Integer crong) {
        if (pobi > crong) {
            return 1;
        } else if (pobi < crong) {
            return 2;
        } else {
            return 0;
        }
    }

    private static int maxSum(List<Integer> num) {
        int max = 0;

        for (int i = 0; i < num.size(); i++) {
            max = Math.max(plusSum(num.get(i)), multiSum(num.get(i)));
        }

        return max;
    }

    private static int plusSum(Integer num) {
        int plusSum = 0;

        while (num > 0) {
            plusSum += num % 10;
            num /= 10;
        }

        return plusSum;
    }
}
