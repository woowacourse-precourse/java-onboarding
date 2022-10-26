package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    private static final int START_PAGE_NUMBER = 1;
    private static final int END_PAGE_NUMBER = 400;
    private static final int WINNER_USER1_MESSAGE = 1;
    private static final int WINNER_USER2_MESSAGE = 2;
    private static final int SCORE_SAME_MESSAGE = 0;
    private static final int EXCEPTION_MESSAGE = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (validatePageNumber(pobi) == -1 && validatePageNumber(crong) == -1) {
            return -1;
        }

        List<Integer> pobiBiggerPageNumbers = saveUserBiggerPageNumber(pobi);
        List<Integer> crongBiggerPageNumbers = saveUserBiggerPageNumber(crong);

        int pobiScore = validateBiggerNumber(pobiBiggerPageNumbers.get(0), pobiBiggerPageNumbers.get(1));
        int crongScore = validateBiggerNumber(crongBiggerPageNumbers.get(0), crongBiggerPageNumbers.get(1));

        return winnerUser(pobiScore, crongScore);
    }

    private static int winnerUser(int userScore1, int userScore2) {
        if (userScore1 > userScore2) {
            return WINNER_USER1_MESSAGE;
        } else if (userScore1 < userScore2) {
            return WINNER_USER2_MESSAGE;
        }
        return SCORE_SAME_MESSAGE;
    }

    private static List<Integer> saveUserBiggerPageNumber(List<Integer> user) {
        List<Integer> biggerPageNumbers = new ArrayList<>();
        for (Integer pageNumber : user) {
            int sumPage = sumEachNumber(pageNumber);
            int multPage = multEachNumber(pageNumber);
            biggerPageNumbers.add(validateBiggerNumber(sumPage, multPage));
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

    private static int validateBiggerNumber(int number1, int number2) {
        return Math.max(number1, number2);
    }

    private static int validatePageNumber(List<Integer> user) {
        int leftPageNumber = user.get(0);
        int rightPageNumber = user.get(1);
        if (!isPageOdd(leftPageNumber) ||
                isPageOdd(rightPageNumber) ||
                isFirstPage(leftPageNumber) ||
                isEndPage(rightPageNumber) ||
                isPageSizeLackOrOverflow(leftPageNumber) ||
                isPageSizeLackOrOverflow(rightPageNumber) ||
                !isPageContinue(leftPageNumber, rightPageNumber)) {
            return EXCEPTION_MESSAGE;
        }

        return 0;
    }

    private static boolean isPageOdd(int pageNumber) {
        return pageNumber % 2 != 0;
    }

    private static boolean isFirstPage(int pageNumber) {
        return pageNumber == START_PAGE_NUMBER || pageNumber == START_PAGE_NUMBER + 1;
    }

    private static boolean isEndPage(int pageNumber) {
        return pageNumber == END_PAGE_NUMBER - 1 || pageNumber == END_PAGE_NUMBER;
    }

    private static boolean isPageSizeLackOrOverflow(int pageNumber) {
        return pageNumber < START_PAGE_NUMBER || pageNumber > END_PAGE_NUMBER;
    }

    private static boolean isPageContinue(int leftPageNumber, int rightPageNumber) {
        return leftPageNumber+1 == rightPageNumber;
    }
}