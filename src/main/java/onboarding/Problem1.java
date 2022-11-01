package onboarding;

import java.util.List;

class Problem1 {

    private static final int WIN_POBI = 1;
    private static final int WIN_CRONG = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTIONS = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (hasExceptions(pobi) || hasExceptions(crong)) {
            return EXCEPTIONS;
        }

        int scorePobi = maxScore(List.of(add(pobi.get(0)), multiply(pobi.get(0)), add(pobi.get(1)), multiply(pobi.get(1))));
        int scoreCrong = maxScore(List.of(add(crong.get(0)), multiply(crong.get(0)), add(crong.get(1)), multiply(crong.get(1))));

        return decideWinner(scorePobi, scoreCrong);
    }

    private static boolean hasExceptions(List<Integer> pageNumbers) {
        int left = pageNumbers.get(0);
        int right = pageNumbers.get(1);

        if (left + 1 != right) {
            return true;
        }
        if (left % 2 == 0) {
            return true;
        }
        if (left < 1 || right > 400) {
            return true;
        }
        return false;
    }

    private static int add(int pageNumber) {
        int result = 0;
        while (pageNumber > 0) {
            result += pageNumber % 10;
            pageNumber /= 10;
        }
        return result;
    }

    private static int multiply(int pageNumber) {
        int result = 1;
        while (pageNumber > 0) {
            result *= pageNumber % 10;
            pageNumber /= 10;
        }
        return result;
    }

    private static int maxScore(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare).orElse(-1);
    }

    private static int decideWinner(int p, int c) {
        if (p > c) {
            return WIN_POBI;
        } else if (p < c) {
            return WIN_CRONG;
        } else {
            return DRAW;
        }
    }
}