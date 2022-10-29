package onboarding;

import java.util.List;


class Problem1 {

    private static int MIN_PAGE = 1;
    private static int MAX_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isValid(pobi) || !isValid(crong)) {
            return -1;
        }

        int pobiScore = getScore(pobi.get(0), pobi.get(1));
        int crongScore = getScore(crong.get(0), crong.get(1));

        return playGame(pobiScore, crongScore);
    }

    private static boolean isValid(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (!checkRange(leftPage) || !checkRange(rightPage)) {
            return false;
        } else if (!isOdd(leftPage)) {
            return false;
        } else if (!isEven(rightPage)) {
            return false;
        } else if (!isPair(leftPage, rightPage)) {
            return false;
        }

        return true;
    }

    private static boolean checkRange(int page) {
        return page > MIN_PAGE && page < MAX_PAGE;
    }

    private static boolean isEven(int page) {
        return page % 2 == 0;
    }

    private static boolean isOdd(int page) {
        return page % 2 != 0;
    }

    private static boolean isPair(int leftPage, int rightPage) {
        return rightPage - leftPage == 1;
    }

    private static int getScore(int leftPage, int rightPage) {
        return Math.max(getMax(leftPage), getMax(rightPage));
    }

    private static int getMax(int page) {
        return Math.max(sumOfPageDigits(page), mulOfPageDigits(page));
    }

    private static int sumOfPageDigits(int page) {
        int sum = 0;

        while (page > 0) {
            sum += (page % 10);
            page /= 10;
        }

        return sum;
    }

    private static int mulOfPageDigits(int page) {
        int mul = 1;

        while (page > 0) {
            mul *= (page % 10);
            page /= 10;
        }

        return mul;
    }

    private static int playGame(int pobiScore, int crongScore) {
        if (isPobiWinner(pobiScore, crongScore)) {
            return 1;
        } else if (isCrongWinner(pobiScore, crongScore)) {
            return 2;
        } else {
            return 0;
        }
    }

    private static boolean isPobiWinner(int pobiScore, int crongScore) {
        return pobiScore > crongScore;
    }

    private static boolean isCrongWinner(int pobiScore, int crongScore) {
        return pobiScore < crongScore;
    }

}