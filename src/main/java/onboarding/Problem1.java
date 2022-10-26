package onboarding;

import java.util.List;

class Problem1 {

    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = getWinner(pobi, crong);

        if (pageValidation(pobi) && pageValidation(crong)) {
            if (answer == 0) {
                return DRAW;
            } else if (answer > 0) {
                return POBI_WIN;
            } else if (answer < 0) {
                return CRONG_WIN;
            }
        }
        return EXCEPTION;
    }

    private static int numberAdd(int number) {
        int result = 0;
        while (number != 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }

    private static int numberMultiply(int number) {
        int result = 1;
        while (number != 0) {
            result *= number % 10;
            number /= 10;
        }
        return result;
    }

    private static int getMaxNumber(int firstValue, int secondValue) {
        return Math.max(firstValue, secondValue);
    }

    private static int getBiggerNumberOfAddition(List<Integer> pages) {
        return getMaxNumber(numberAdd(pages.get(0)), numberAdd(pages.get(1)));
    }

    private static int getBiggerNumberOfMultiplication(List<Integer> pages) {
        return getMaxNumber(numberMultiply(pages.get(0)), numberMultiply(pages.get(1)));
    }

    private static int maxOfPageCalculate(List<Integer> pages) {
        return getMaxNumber(getBiggerNumberOfAddition(pages), getBiggerNumberOfMultiplication(pages));
    }

    private static int getWinner(List<Integer> user1, List<Integer> user2) {
        return maxOfPageCalculate(user1) - maxOfPageCalculate(user2);
    }

    private static boolean pageValidation(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (leftPage % 2 == 1 && leftPage + 1 == rightPage) {
            return true;
        }
        return false;
    }
}