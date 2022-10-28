package onboarding;

import java.util.List;

class Problem1 {

    private static final int MIN_LEFT_PAGE = 1;
    private static final int MAX_LEFT_PAGE = 399;
    private static final int MIN_RIGHT_PAGE = 2;
    private static final int MAX_RIGHT_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiMax = calc(pobi.get(0), pobi.get(1));
        int crongMax = calc(crong.get(0), crong.get(1));

        return getWinner(pobiMax, crongMax);
    }

    private static int getWinner(int pobi, int crong) {

        if (pobi == -1 || crong == -1) {
            return -1;
        }
        else if (pobi > crong) {
            return 1;
        }
        else if (pobi < crong) {
            return 2;
        }
        else if (pobi == crong) {
            return 0;
        }
        else {
            throw new IllegalArgumentException("???");
        }
    }

    private static int calc(int left, int right) {

        if (validateNumbers(left, right)) {
            return -1;
        }

        int leftResult = calcPage(left);
        int rightResult = calcPage(right);

        return Math.max(leftResult, rightResult);
    }

    private static int calcPage(int page) {
        int sum = 0;
        int mul = 1;

        while(page != 0) {
            int n = page % 10;
            sum += n;
            mul *= n;
            page /= 10;
        }

        return Math.max(sum, mul);
    }

    private static boolean validateNumbers(Integer left, Integer right) {

        boolean isNull = left == null || right == null;
        boolean isLeftOdd = left % 2 == 1;
        boolean isRightEven = right % 2 == 0;
        boolean isLeftWithinRange = (MIN_LEFT_PAGE <= left) && (left <= MAX_LEFT_PAGE);
        boolean isRightWithinRange = (MIN_RIGHT_PAGE <= right) && (right <= MAX_RIGHT_PAGE);
        boolean isCorrectPages = right - left == 1;

        if (
            !isNull &&
            isLeftOdd &&
            isRightEven &&
            isLeftWithinRange &&
            isRightWithinRange &&
            isCorrectPages
        ) {
            return false;
        }

        return true;
    }
}
