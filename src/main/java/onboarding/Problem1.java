package onboarding;

import java.util.List;

class Problem1 {

    private static final int LEFT_PAGE_INDEX = 0;
    private static final int RIGHT_PAGE_INDEX = 1;
    private static final int MIN_PAGE = 1;
    private static final int MAX_PAGE = 400;

    private static final int CRONG_WIN = 2;
    private static final int POBI_WIN = 1;
    private static final int DRAW = 0;

    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validate(pobi, crong)) return EXCEPTION;

        return playGame(pobi, crong);
    }

    private static boolean validate(List<Integer> pobi, List<Integer> crong) {
        if (!validateCorrectPageSize(pobi, crong)) return false;
        if (!validateCorrectPageOrder(pobi) || !validateCorrectPageOrder(crong)) return false;
        if (!validateConnectPage(pobi) || !validateConnectPage(crong)) return false;
        if (!validateCorrectPageRange(pobi) || !validateCorrectPageRange(crong)) return false;

        return true;
    }

    private static boolean validateCorrectPageSize(List<Integer> pobi, List<Integer> crong) {
        return pobi.size() == 2 && crong.size() == 2;
    }

    private static boolean validateCorrectPageRange(List<Integer> pages) {
        return pages.get(LEFT_PAGE_INDEX) >= MIN_PAGE && pages.get(RIGHT_PAGE_INDEX) <= MAX_PAGE;
    }

    private static boolean validateCorrectPageOrder(List<Integer> pages) {
        return pages.get(LEFT_PAGE_INDEX) % 2 == 1 && pages.get(RIGHT_PAGE_INDEX) % 2 == 0;
    }

    private static boolean validateConnectPage(List<Integer> pages) {
        return pages.get(LEFT_PAGE_INDEX) == pages.get(RIGHT_PAGE_INDEX) - 1;
    }

    private static int getMSum(int page) {
        int sum = 0;
        while (page > 0) {
            sum += page % 10;
            page /= 10;
        }

        return sum;
    }

    private static int getMul(int page) {
        int mul = 1;
        while (page > 0) {
            mul *= page % 10;
            page /= 10;
        }

        return mul;
    }

    private static int getMAxScore(List<Integer> pages) {
        return Math.max(getMSum(pages.get(0)), getMul(pages.get(1)));
    }

    private static int playGame(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = getMAxScore(pobi);
        int crongScore = getMAxScore(crong);

        return pobiScore > crongScore ? POBI_WIN : pobiScore < crongScore ? CRONG_WIN : DRAW;
    }
}