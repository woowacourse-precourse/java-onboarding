package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (PageNumberException.validates(pobi) == Constance.EXCEPTION_MESSAGE ||
                PageNumberException.validates(crong) == Constance.EXCEPTION_MESSAGE) {
            return Constance.EXCEPTION_MESSAGE;
        }

        List<Integer> pobiBiggerPageNumbers = saveMaxPagesNumberByUser(pobi);
        List<Integer> crongBiggerPageNumbers = saveMaxPagesNumberByUser(crong);

        int pobiScore = getMaxNumber(pobiBiggerPageNumbers.get(0), pobiBiggerPageNumbers.get(1));
        int crongScore = getMaxNumber(crongBiggerPageNumbers.get(0), crongBiggerPageNumbers.get(1));

        return winnerUser(pobiScore, crongScore);
    }

    private static int winnerUser(int userScore1, int userScore2) {
        if (userScore1 > userScore2) {
            return Constance.WINNER_USER1_MESSAGE;
        } else if (userScore1 < userScore2) {
            return Constance.WINNER_USER2_MESSAGE;
        }
        return Constance.SCORE_SAME_MESSAGE;
    }

    private static List<Integer> saveMaxPagesNumberByUser(List<Integer> user) {
        List<Integer> biggerPageNumbers = new ArrayList<>();
        for (Integer pageNumber : user) {
            int sumPage = sumEachNumber(pageNumber);
            int multPage = multEachNumber(pageNumber);
            biggerPageNumbers.add(getMaxNumber(sumPage, multPage));
        }
        return biggerPageNumbers;
    }

    private static int sumEachNumber(int pageNumber) {
        int sum = 0;
        String strPageNumber = String.valueOf(pageNumber);
        for (int i = 0; i < strPageNumber.length(); i++) {
            sum += Integer.parseInt(String.valueOf(strPageNumber.charAt(i)));
        }

        return sum;
    }

    private static int multEachNumber(int pageNumber) {
        int mult = 1;
        String strPageNumber = String.valueOf(pageNumber);
        for (int i = 0; i < strPageNumber.length(); i++) {
            mult *= Integer.parseInt(String.valueOf(strPageNumber.charAt(i)));
        }

        return mult;
    }

    private static int getMaxNumber(int number1, int number2) {
        return Math.max(number1, number2);
    }

    private static final class Constance {
        private static final int START_PAGE_NUMBER = 1;
        private static final int END_PAGE_NUMBER = 400;
        private static final int WINNER_USER1_MESSAGE = 1;
        private static final int WINNER_USER2_MESSAGE = 2;
        private static final int SCORE_SAME_MESSAGE = 0;
        private static final int EXCEPTION_MESSAGE = -1;
    }

    private static class PageNumberException {

        private PageNumberException() {}

        public static int validates(List<Integer> user) {
            int leftPageNumber = user.get(0);
            int rightPageNumber = user.get(1);
            if (!isPageOdd(leftPageNumber) ||
                    isPageOdd(rightPageNumber) ||
                    isFirstPage(leftPageNumber) ||
                    isEndPage(rightPageNumber) ||
                    isPageSizeLackOrOverflow(leftPageNumber) ||
                    isPageSizeLackOrOverflow(rightPageNumber) ||
                    !isPageContinue(leftPageNumber, rightPageNumber)) {
                return Constance.EXCEPTION_MESSAGE;
            }

            return 0;
        }

        private static boolean isPageOdd(int pageNumber) {
            return pageNumber % 2 != 0;
        }

        private static boolean isFirstPage(int pageNumber) {
            return pageNumber == Constance.START_PAGE_NUMBER || pageNumber == Constance.START_PAGE_NUMBER + 1;
        }

        private static boolean isEndPage(int pageNumber) {
            return pageNumber == Constance.END_PAGE_NUMBER - 1 || pageNumber == Constance.END_PAGE_NUMBER;
        }

        private static boolean isPageSizeLackOrOverflow(int pageNumber) {
            return pageNumber < Constance.START_PAGE_NUMBER || pageNumber > Constance.END_PAGE_NUMBER;
        }

        private static boolean isPageContinue(int leftPageNumber, int rightPageNumber) {
            return leftPageNumber+1 == rightPageNumber;
        }
    }


}