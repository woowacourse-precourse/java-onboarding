package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    private static final char ZERO = '0';
    private static final int POBI = 1;
    private static final int CRONG = 2;
    private static final int TIE = 0;
    private static final int EXCEPTION = -1;
    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;
    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isInValidPageNumber(pobi, crong)) {
            return EXCEPTION;
        }

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        return getWinner(pobiScore, crongScore);
    }

    private static List<List<Integer>> getEachDigitOfTwoPages(List<Integer> pages) {
        List<List<Integer>> digitsOfTwoPages = new ArrayList<>();

        for (int page : pages) {
            digitsOfTwoPages.add(getEachDigit(page));
        }

        return digitsOfTwoPages;
    }

    private static List<Integer> getEachDigit(Integer page) {
        List<Integer> digits = new ArrayList<>();
        String pageString = page.toString();

        for (char digit : pageString.toCharArray()) {
            digits.add(digit - ZERO);
        }

        return digits;
    }

    private static Integer getScore(List<Integer> pages) {
        List<List<Integer>> digitsOfTwoPages = getEachDigitOfTwoPages(pages);

        List<Integer> num = new ArrayList<>();
        for (List<Integer> digits : digitsOfTwoPages) {
            num.add(plusEachDigit(digits));
            num.add(multiplyEachDigit(digits));
        }

        return Collections.max(num);
    }

    private static Integer plusEachDigit(List<Integer> digits) {
        int sum = 0;
        for (Integer digit : digits) {
            sum += digit;
        }

        return sum;
    }

    private static Integer multiplyEachDigit(List<Integer> digits) {
        int sum = 1;
        for (Integer digit : digits) {
            sum *= digit;
        }

        return sum;
    }

    private static Integer getWinner(Integer pobiScore, Integer crongScore) {
        if (pobiScore > crongScore) {
            return POBI;
        }
        if (pobiScore < crongScore) {
            return CRONG;
        }

        return TIE;
    }

    private static boolean isInValidPageNumber(List<Integer> pobi, List<Integer> crong) {
        return isInValidPageNumber(pobi) || isInValidPageNumber(crong);
    }

    private static boolean isInValidPageNumber(List<Integer> pages) {
        return !isValidPageRange(pages) || !isValidPageOddEven(pages) || !isValidPageSequence(pages);
    }

    private static boolean isValidPageRange(List<Integer> pages) {
        for (Integer page : pages) {
            if (page < FIRST_PAGE || page > LAST_PAGE) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidPageOddEven(List<Integer> pages) {
        int leftPage = pages.get(LEFT);
        int rightPage = pages.get(RIGHT);

        return !isEven(leftPage) && isEven(rightPage);
    }

    private static boolean isEven(int num) {
        return (num % 2) == 0;
    }

    private static boolean isValidPageSequence(List<Integer> pages) {
        int leftPage = pages.get(LEFT);
        int rightPage = pages.get(RIGHT);

        return ++leftPage == rightPage;
    }
}