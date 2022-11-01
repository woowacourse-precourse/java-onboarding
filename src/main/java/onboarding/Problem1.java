package onboarding;

import java.util.List;

class Problem1 {
    public static int IS_NOT_VALID = -1;
    public static int FIRST_PLAYER_WIN = 1;
    public static int SECOND_PLAYER_WIN = 2;
    public static int GAME_IN_A_TIE = 0;
    public static int FIRST_PAGE = 1;
    public static int LAST_PAGE = 400;
    public static int LEFT_PAGE_INDEX = 0;
    public static int RIGHT_PAGE_INDEX = 1;

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
        }
        if (!isContinuous(leftPage, rightPage)) {
            return false;
        }
        if (!isOddNumber(leftPage) || !isEvenNumber(rightPage)) {
            return false;
        }
        if (!isValidRange(leftPage) || !isValidRange(rightPage)) {
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

    public static int sumDigit(int page) {
        int sum = 0;
        while (page > 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    public static int multiplyDigit(int page) {
        int multi = 1;
        while (page > 0) {
            multi *= page % 10;
            page /= 10;
        }
        return multi;
    }

    public static int getMaxScoreOfMultiAndSum(int page) {
        int multiScore = multiplyDigit(page);
        int sumScore = sumDigit(page);
        return Math.max(multiScore, sumScore);
    }

    public static int getPlayerMaxScore(List<Integer> pages) {
        int leftMaxScore = getMaxScoreOfMultiAndSum(pages.get(LEFT_PAGE_INDEX));
        int rightMaxScore = getMaxScoreOfMultiAndSum(pages.get(RIGHT_PAGE_INDEX));
        return Math.max(leftMaxScore, rightMaxScore);
    }

}