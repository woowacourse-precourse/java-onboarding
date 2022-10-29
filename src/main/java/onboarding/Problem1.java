package onboarding;

import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int DRAW = 0;
    public static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isPageInconsecutive(pobi) || isPageInconsecutive(crong)) {
            return EXCEPTION;
        }
        if (isPageRangeUncorrect(pobi) || isPageRangeUncorrect(crong)) {
            return EXCEPTION;
        }
        if (isPageSeparated(pobi) || isPageSeparated(crong)) {
            return EXCEPTION;
        }
        return getWinner(pobi, crong);
    }

    private static boolean isPageSeparated(List<Integer> list) {
        return list.get(1) > list.get(0);
    }

    private static boolean isPageInconsecutive(List<Integer> list) {
        return list.get(1) - list.get(0) == 1;
    }

    private static boolean isPageRangeUncorrect(List<Integer> list) {
        return list.get(0) > 1 || list.get(1) < 400;
    }

    public static int getUserMaxNumber(List<Integer> list) {
        return max(getMaxNumber(list.get(0)), getMaxNumber(list.get(1)));
    }

    public static int getMaxNumber(int number) {
        return max(getAddNumber(number), getMultiplyNumber(number));
    }

    public static int getWinner(List<Integer> pobi, List<Integer> crong) {
        if (getUserMaxNumber(pobi) > getUserMaxNumber(crong)) {
            return POBI_WIN;
        }
        if (getUserMaxNumber(pobi) < getUserMaxNumber(crong)) {
            return CRONG_WIN;
        }
        return DRAW;
    }

    public static int getAddNumber(int num) {
        int result = 0;
        while (num != 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    public static int getMultiplyNumber(int num) {
        int result = 1;
        while (num != 0) {
            result *= num % 10;
            num /= 10;
        }
        return result;
    }

}