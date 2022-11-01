package onboarding;

import java.util.List;

class Problem1 {
    private static final String MESSAGE = "잘못된 입력입니다.";

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isInputValid(pobi, crong) || isOutOfRange(pobi, crong) || !isLeftPageOdd(pobi, crong)
                || !isRightPageEven(pobi, crong) || !isConsecutive(pobi, crong)) {
            return -1;
        }

        return getWinner(getMaxScore(pobi), getMaxScore(crong));
    }

    private static int getMaxSumOrMultiply(int num) {
        int sum = 0;
        int multi = 1;

        while (num > 0) {
            sum += (num % 10);
            multi *= (num % 10);
            num /= 10;
        }
        return Math.max(sum, multi);
    }

    private static int getWinner(int pobi, int crong) {
        if (pobi > crong) {
            return 1;
        } else if (pobi < crong) {
            return 2;
        } else {
            return 0;
        }
    }

    private static boolean isOutOfRange(List<Integer> pobi, List<Integer> crong) {
        return pobi.get(0) < 1 || pobi.get(0) > 400 || pobi.get(1) < 1 || pobi.get(1) > 400 ||
                crong.get(0) < 1 || crong.get(0) > 400 || crong.get(1) < 1 || crong.get(1) > 400;
    }

    private static boolean isLeftPageOdd(List<Integer> pobi, List<Integer> crong) {
        return (pobi.get(0) % 2 == 1) && (crong.get(0) % 2 == 1);
    }

    private static boolean isRightPageEven(List<Integer> pobi, List<Integer> crong) {
        return (pobi.get(1) % 2 == 0) && (crong.get(1) % 2 == 0);
    }

    private static boolean isConsecutive(List<Integer> pobi, List<Integer> crong) {
        return (pobi.get(0) + 1 == pobi.get(1)) && (crong.get(0) + 1 == crong.get(1));
    }

    private static boolean isInputValid(List<Integer> pobi, List<Integer> crong) {
        if ((pobi.size() != 2) && (crong.size() != 2)) {
            throw new IllegalArgumentException(MESSAGE);
        }
        return true;
    }

    private static int getMaxScore(List<Integer> player) {
        int leftPage = player.get(0);
        int rightPage = player.get(1);

        return Math.max(getMaxSumOrMultiply(leftPage), getMaxSumOrMultiply(rightPage));
    }
}