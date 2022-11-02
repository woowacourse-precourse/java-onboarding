package onboarding;

import java.util.List;

class Problem1 {
    private static final int IS_NOT_VALID = -1;
    private static final int FIRST_PLAYER_WIN = 1;
    private static final int SECOND_PLAYER_WIN = 2;
    private static final int GAME_IN_A_TIE = 0;
    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;
    private static final int LEFT_PAGE_INDEX = 0;
    private static final int RIGHT_PAGE_INDEX = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isValidInputSet(pobi, crong)) {
            return IS_NOT_VALID;
        }
        int pobiMaxScore = getPlayerMaxScore(pobi);
        int crongMaxScore = getPlayerMaxScore(crong);

        return getGameResult(pobiMaxScore, crongMaxScore);
    }

    public static int getGameResult(int firstPlayScore, int secondPlayerScore) {
        if (firstPlayScore > secondPlayerScore) {
            return FIRST_PLAYER_WIN;
        } else if (secondPlayerScore > firstPlayScore) {
            return SECOND_PLAYER_WIN;
        } else {
            return GAME_IN_A_TIE;
        }
    }

    public static boolean isValidInputSet(List<Integer> firstPlayer, List<Integer> secondPlayer) {
        return isValidInput(firstPlayer) && isValidInput(secondPlayer);
    }

    public static boolean isValidInput(List<Integer> pages) {
        Integer leftPage = pages.get(LEFT_PAGE_INDEX);
        Integer rightPage = pages.get(RIGHT_PAGE_INDEX);

        if (!isValidNumber(leftPage, rightPage)) {
            return false;
        } else if (!isContinuous(leftPage, rightPage)) {
            return false;
        } else if (!isOddNumber(leftPage) || !isEvenNumber(rightPage)) {
            return false;
        } else if (!isValidRange(leftPage) || !isValidRange(rightPage)) {
            return false;
        }
        return true;
    }

    public static boolean isOddNumber(int page) {
        return page % 2 == 1;
    }

    public static boolean isEvenNumber(int page) {
        return page % 2 == 0;
    }

    public static boolean isValidRange(int page) {
        return page >= FIRST_PAGE && page <= LAST_PAGE;
    }

    public static boolean isValidNumber(Integer leftPage, Integer rightPage) {
        return leftPage != null && rightPage != null;
    }

    public static boolean isContinuous(int leftPage, int rightPage) {
        return rightPage - leftPage == 1;
    }

    public static int getSumDigit(int page) {
        int sum = 0;
        while (page > 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    public static int getMultiplyDigit(int page) {
        int multi = 1;
        while (page > 0) {
            multi *= page % 10;
            page /= 10;
        }
        return multi;
    }

    public static int getMaxScoreOfMultiAndSum(int page) {
        int multiScore = getMultiplyDigit(page);
        int sumScore = getSumDigit(page);
        return Math.max(multiScore, sumScore);
    }

    public static int getPlayerMaxScore(List<Integer> pages) {
        int leftMaxScore = getMaxScoreOfMultiAndSum(pages.get(LEFT_PAGE_INDEX));
        int rightMaxScore = getMaxScoreOfMultiAndSum(pages.get(RIGHT_PAGE_INDEX));
        return Math.max(leftMaxScore, rightMaxScore);
    }

}