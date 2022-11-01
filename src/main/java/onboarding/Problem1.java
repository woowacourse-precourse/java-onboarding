package onboarding;

import onboarding.problem1.Page;

import java.util.Comparator;
import java.util.List;

class Problem1 {
    private static final int LEFT_PAGE_INDEX = 0;
    private static final int RIGHT_PAGE_INDEX = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            validatePageNumberGap(pobi.get(LEFT_PAGE_INDEX), pobi.get(RIGHT_PAGE_INDEX));
            validateLeftPageNumberIsOdd(pobi.get(LEFT_PAGE_INDEX));
            pobi.stream()
                    .forEach(pobiPage -> new Page(pobiPage));
            validatePageNumberGap(crong.get(LEFT_PAGE_INDEX), crong.get(RIGHT_PAGE_INDEX));
            validateLeftPageNumberIsOdd(crong.get(LEFT_PAGE_INDEX));
            crong.stream()
                    .forEach(crongPage -> new Page(crongPage));
        } catch (IllegalArgumentException e) {
            return -1;
        }

        Integer pobiScore = pobi.stream()
                .map(page -> getMaxNumber(getSumOfPageDigits(page), getProductOfPageDigits(page)))
                .max(Comparator.comparing(Integer::intValue))
                .get();

        Integer crongScore = crong.stream()
                .map(page -> getMaxNumber(getSumOfPageDigits(page), getProductOfPageDigits(page)))
                .max(Comparator.comparing(Integer::intValue))
                .get();

        return getMatchResult(pobiScore, crongScore);
    }

    public static int getSumOfPageDigits(int pageNumber) {
        int result = 0;
        while (pageNumber > 0) {
            result += pageNumber % 10;
            pageNumber /= 10;
        }
        return result;
    }

    public static int getProductOfPageDigits(int pageNumber) {
        int result = 1;
        while (pageNumber > 0) {
            result *= pageNumber % 10;
            pageNumber /= 10;
        }
        return result;
    }

    public static int getMaxNumber(int number1, int number2) {
        return Math.max(number1, number2);
    }

    public static int getMatchResult(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        }

        if (crongScore > pobiScore) {
            return 2;
        }

        return 0;
    }

    public static void validatePageNumberGap(int leftPage, int rightPage) {
        if (rightPage - leftPage != 1) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateLeftPageNumberIsOdd(int leftPage) {
        if (leftPage % 2 == 0) {
            throw new IllegalArgumentException();
        }
    }
}