package onboarding;

import java.util.List;

class Problem1 {

    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;
    private static final int NEXT_PAGE_INC = 1;
    private static final int LEFT_PARAM_WIN_SCORE = 1;
    private static final int RIGHT_PARAM_WIN_SCORE = 2;
    private static final int DRAW_SCORE = 0;
    private static final int EXCEPTION_CODE = -1;

    /* 추상화를 이용해 다양한 계산 방식으로 확장할 수 있도록 */
    static abstract class DigitsCalculator {
        abstract int calculate(char[] digits);
    }

    static class DigitsSum extends DigitsCalculator {
        @Override
        int calculate(char[] digits) {
            int result = 0;
            for (char digit : digits) {
                result += digit - '0';
            }
            return result;
        }
    }

    static class DigitMultiply extends DigitsCalculator {
        @Override
        int calculate(char[] digits) {
            int result = 1;
            for (char digit : digits) {
                result *= digit - '0';
            }
            return result;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        /* 입력 예외 검증 */
        if (!validateInput(pobi) || !validateInput(crong))
            return EXCEPTION_CODE;
        return compare(getScore(pobi), getScore(crong));
    }

    static boolean validateInput(List<Integer> list) {
        boolean validList = list.size() == 2;
        boolean pageBoundary = list.get(0) > FIRST_PAGE && list.get(1) < LAST_PAGE;
        boolean startWithOdd = list.get(0) % 2 == 1;
        boolean pagesInRow = (list.get(0) + NEXT_PAGE_INC) == list.get(1);
        return validList && pageBoundary && startWithOdd && pagesInRow;
    }

    static int calculateEachDigit(int number, DigitsCalculator rule) {
        char[] digits = numToDigits(number);
        return rule.calculate(digits);
    }

    // 왼쪽/오른쪽 페이지 번호에 대한 합의 결과 곱의 결과 중 MAX인 값을 반환
    static int getScore(List<Integer> list) {
        int mostMax = 0;
        for (Integer page : list) {
            int comp = Math.max(calculateEachDigit(page, new DigitsSum()), calculateEachDigit(page, new DigitMultiply()));
            if (mostMax < comp)
                mostMax = comp;
        }
        return mostMax;
    }

    static char[] numToDigits(int number) {
        return String.valueOf(number).toCharArray();
    }

    static int compare(int x, int y) {
        return x > y ? LEFT_PARAM_WIN_SCORE : x == y ? DRAW_SCORE : RIGHT_PARAM_WIN_SCORE;
    }
}