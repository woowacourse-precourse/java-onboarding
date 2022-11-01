package onboarding;

import java.util.List;

class Problem1 {
    private static final int LEFT_INDEX = 0;
    private static final int RIGHT_INDEX = 1;
    private static final int MIN_PAGE_NUMBER = 1;
    private static final int MAX_PAGE_NUMBER = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isNotValid(pobi, crong)) {
            return -1;
        }
        int pobiScore = findScore(pobi);
        int crongScore = findScore(crong);
        return findWinner(pobiScore, crongScore);
    }

    private static boolean isNotValid(List<Integer> pobi, List<Integer> crong) {
        try {
            validate(pobi);
            validate(crong);
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    private static void validate(List<Integer> page) {
        if (page.size() < 2) {
            throw new IllegalArgumentException();
        }
        if ((page.get(RIGHT_INDEX) - page.get(LEFT_INDEX)) != 1) {
            throw new IllegalArgumentException();
        }
        if (page.get(LEFT_INDEX) < MIN_PAGE_NUMBER || page.get(RIGHT_INDEX) > MAX_PAGE_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private static int findWinner(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        }
        if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }

    private static int findScore(List<Integer> page) {
        int leftPageScore = findMax(page.get(LEFT_INDEX));
        int rightPageScore = findMax(page.get(RIGHT_INDEX));
        return compareScore(leftPageScore, rightPageScore);
    }

    private static int compareScore(int leftPageScore, int rightPageScore) {
        if (leftPageScore > rightPageScore) {
            return leftPageScore;
        }
        return rightPageScore;
    }

    private static int findMax(int pageNumber) {
        return compareScore(sumEach(pageNumber), multiplyEach(pageNumber));
    }

    private static int multiplyEach(int pageNumber) {
        int total = 1;
        while (isExist(pageNumber)) {
            total *= pageNumber % 10;
            pageNumber /= 10;
        }
        total *= pageNumber % 10;
        return total;
    }

    private static int sumEach(int pageNumber) {
        int total = 0;
        while (isExist(pageNumber)) {
            total += pageNumber % 10;
            pageNumber /= 10;
        }
        total += pageNumber % 10;
        return total;
    }

    private static boolean isExist(int pageNumber) {
        return pageNumber / 10 != 0;
    }
}
