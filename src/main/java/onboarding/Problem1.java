package onboarding;

import java.util.List;

public class Problem1 {

    static final int EXCEPTION = -1;
    static final int POBI_WIN = 1;
    static final int CRONG_WIN = 2;
    static final int DRAW = 0;

    static final int FIRST_PAGE_NUMBER = 1;
    static final int LAST_PAGE_NUMBER = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (isNotValidPages(pobi, crong)) {
            return EXCEPTION;
        }

        int numberOfPobi = getBiggestNumber(pobi);
        int numberOfCrong = getBiggestNumber(crong);

        return getWinner(numberOfPobi, numberOfCrong);
    }

    private static boolean isNotValidPages(List<Integer> pobi, List<Integer> crong) {
        return !(isValidPage(pobi) && isValidPage(crong));
    }

    private static boolean isValidPage(List<Integer> pages) {
        for (int pageNumber : pages) {
            if (pageNumber < FIRST_PAGE_NUMBER) {
                return false;
            }

            if (pageNumber > LAST_PAGE_NUMBER) {
                return false;
            }
        }

        return isNextPage(pages);
    }

    private static boolean isNextPage(List<Integer> pages) {
        int leftPageNumber = pages.get(0);
        int rightPageNumber = pages.get(1);

        return leftPageNumber == rightPageNumber - 1;
    }
    /*
       0 == 홀수
       1 == 짝수
     */

    private static int getBiggestNumber(List<Integer> pobi) {
        int maxNumber = 0;

        for (int page : pobi) {
            maxNumber = Math.max(maxNumber, getBigNumber(page));
        }

        return maxNumber;
    }

    private static int getBigNumber(int pageNumber) {
        return Math.max(sumNumber(pageNumber), mulNumber(pageNumber));
    }

    private static int sumNumber(int pageNumber) {
        int number = 0;
        String stringPageNumber = Integer.toString(pageNumber);

        for (int i = 0; i < stringPageNumber.length(); i++) {
            number += stringPageNumber.charAt(i) - '0';
        }

        return number;
    }

    private static int mulNumber(int pageNumber) {
        int number = 1;
        String stringPageNumber = Integer.toString(pageNumber);

        for (int i = 0; i < stringPageNumber.length(); i++) {
            number *= stringPageNumber.charAt(i) - '0';
        }

        return number;
    }

    private static int getWinner(int numberOfPobi, int numberOfCrong) {
        if (numberOfPobi < numberOfCrong) {
            return CRONG_WIN;
        }

        if (numberOfPobi > numberOfCrong) {
            return POBI_WIN;
        }

        return DRAW;
    }
}
