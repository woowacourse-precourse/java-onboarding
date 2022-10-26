package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        checkValuesValidity(pobi);
        checkValuesValidity(crong);

        if (isWrongPages(pobi, crong)) {
            return -1;
        }

        return findWinner(calculateMaxValue(pobi), calculateMaxValue(crong));
    }

    private static int findWinner(int pobi, int crong) {

        if(pobi > crong) return 1;
        if(pobi < crong) return 2;
        return 0;
    }

    private static int calculateMaxValue(List<Integer> values) {
        return Math.max(calculateMaxSum(values), calculateMaxMultiplication(values));
    }

    private static int calculateMaxMultiplication(List<Integer> values) {
        return Math.max(calculateMultiplication(values.get(0)), calculateMultiplication(values.get(1)));
    }

    private static int calculateMultiplication(Integer value) {

        int multiplyValue = 1;

        while (value != 0) {
            multiplyValue *= value % 10;
            value /= 10;
        }

        return multiplyValue;
    }

    private static int calculateMaxSum(List<Integer> values) {
        return Math.max(calculateSum(values.get(0)), calculateSum(values.get(1)));
    }

    private static int calculateSum(Integer value) {

        int sumValue = 0;

        while (value != 0) {
            sumValue += value % 10;
            value /= 10;
        }

        return sumValue;
    }

    private static boolean isWrongPages(List<Integer> pobi, List<Integer> crong) {

        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            return true;
        }

        return false;
    }

    private static void checkValuesValidity(List<Integer> values) {

        if (!isValidValue(values)) {
            throw new IllegalArgumentException("유효하지 않은 페이지입니다.");
        }
    }

    private static boolean isValidValue(List<Integer> values) {

        if ((0 < values.get(0) && values.get(0) <= 400) && (0 < values.get(1) && values.get(1) <= 400)) {
            return true;
        }

        return false;
    }
}