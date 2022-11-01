package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiPoint = getPoint(pobi);
        if (pobiPoint == -1) {
            return -1;
        }

        int crongPoint = getPoint(crong);
        if (crongPoint == -1) {
            return -1;
        }

        if (pobiPoint == crongPoint) {
            return 0;
        } else if (pobiPoint > crongPoint) {
            return 1;
        } else {
            return 2;
        }
    }

    private static int getPoint(List<Integer> pageNums) {
        int left = pageNums.get(0);
        if (left < 0 || left > 400) {
            return -1;
        } else if (left == 0 || left == 400) {
            return -1;
        }

        int right = pageNums.get(1);
        if (right < 0 || right > 400) {
            return -1;
        } else if (right == 0 || right == 400) {
            return -1;
        }

        if (right - left != 1) {
            return -1;
        }

        int plus = 0;
        int multiply = 1;
        while (left > 0) {
            int digit = left % 10;
            plus += digit;
            multiply *= digit;
            left /= 10;
        }
        int max = Math.max(plus, multiply);
        plus = 0;
        multiply = 1;

        while (right > 0) {
            int digit = right % 10;
            plus += digit;
            multiply *= digit;
            right /= 10;
        }
        max = Math.max(max, Math.max(plus, multiply));
        return max;
    }
}