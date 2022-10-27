package onboarding;

import java.util.List;

/** TODO
 * 1. 입력 값이 옳게 들어왔는지 검증 - 페이지 두개의 값의 차 1
 * 2. 각 페이지의 자리수를 더한 값 곱한 값 중 큰수 구하기
 * 3. 승자 비교
 */
class Problem1 {
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (validationPages(pobi) || validationPages(crong)) {
            return EXCEPTION;
        }
        int pobiMaxValue = getMaxValue(pobi);
        int crongMaxValue = getMaxValue(crong);

        if (pobiMaxValue > crongMaxValue) {
            return POBI_WIN;
        }
        if (crongMaxValue > pobiMaxValue) {
            return CRONG_WIN;
        }
        return DRAW;
    }

    private static boolean validationPages(List<Integer> pages) {
        return pages.get(0) + 1 != pages.get(1);
    }

    private static int getMaxValue(List<Integer> pages) {
        int max = 0;
        for (int page : pages) {
            String[] p = String.valueOf(page).split("");
            max = Math.max(max, getMaxBetweenSumAndMul(p));
        }
        return max;
    }

    private static int getMaxBetweenSumAndMul(String[] page) {
        return Math.max(getSum(page), getMul(page));
    }

    private static int getSum(String[] page) {
        int sum = 0;
        for (String s : page) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    private static int getMul(String[] page) {
        int mul = 1;
        for (String s : page) {
            mul *= Integer.parseInt(s);
        }
        return mul;
    }

}