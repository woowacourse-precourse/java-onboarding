package onboarding;

import java.util.List;

class Problem1 {
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int DRAW = 0;
    public static final int EXCEPTION = -1;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validatePageConsecutive(pobi) || !validatePageConsecutive(crong)) {
            return EXCEPTION;
        }
        if (!validatePageRange(pobi) || !validatePageRange(crong)) {
            return EXCEPTION;
        }
        if (!validatePageSequence(pobi) || !validatePageSequence(crong)) {
            return EXCEPTION;
        }
        return 1;
    }

    private static boolean validatePageSequence(List<Integer> list) {
        return list.get(1) > list.get(0);
    }

    private static boolean validatePageConsecutive(List<Integer> list) {
        return list.get(1) - list.get(0) == 1;
    }

    private static boolean validatePageRange(List<Integer> list) {
        return list.get(0) > 1 ||  list.get(1) < 400;
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