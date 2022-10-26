package onboarding;

import java.util.List;

class Problem1 {
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;

    private static final int EXCEPTION_CASE = -1;
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;

    private static final int VALID_LIST_SIZE = 2;
    private static final int PAGE_START_NUMBER = 3;
    private static final int PAGE_END_NUMBER = 398;
    private static final boolean INVALID = true;
    private static final boolean VALID = false;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isInvalidInput(pobi) || isInvalidInput(crong)) {
            return EXCEPTION_CASE;
        }

        int pobiScore = getPlayerMaxScore(pobi);
        int crongScore = getPlayerMaxScore(crong);

        if (pobiScore > crongScore) {
            return POBI_WIN;
        } else if (pobiScore < crongScore) {
            return CRONG_WIN;
        }

        return DRAW;
    }

    public static String parsePageNumber(int page) {
        return Integer.toString(page);
    }

    public static int calculateSumOfStringDigits(String str) {
        return str.chars()
                .map(Character::getNumericValue)
                .sum();
    }

    public static int calculateMultiplicationOfStringDigits(String str) {
        return str.chars()
                .map(Character::getNumericValue)
                .reduce(1, (ret, digit) -> ret * digit);
    }

    public static int getPlayerMaxScore(List<Integer> player) {
        int leftPageMaxScore = getPageMaxScore(player.get(LEFT_PAGE));
        int rightPageMaxScore = getPageMaxScore(player.get(RIGHT_PAGE));

        return Math.max(leftPageMaxScore, rightPageMaxScore);
    }

    public static int getPageMaxScore(int page) {
        String parsedPageNumber = parsePageNumber(page);
        int sumResult = calculateSumOfStringDigits(parsedPageNumber);
        int multiplicationResult = calculateMultiplicationOfStringDigits(parsedPageNumber);

        return Math.max(sumResult, multiplicationResult);
    }

    public static boolean isInvalidInput(List<Integer> pages) {
        if (!hasValidListSize(pages)) {
            return INVALID;
        } else if (!isSuccessivePages(pages)) {
            return INVALID;
        } else if (!isLeftPageOdd(pages)) {
            return INVALID;
        } else if (!isValidPageNumberRange(pages)) {
            return INVALID;
        }

        return VALID;
    }

    private static boolean hasValidListSize(List<Integer> pages) {
        return pages.size() == VALID_LIST_SIZE;
    }

    private static boolean isValidPageNumberRange(List<Integer> pages) {
        return PAGE_START_NUMBER <= pages.get(LEFT_PAGE) && pages.get(LEFT_PAGE) < PAGE_END_NUMBER;
    }

    private static boolean isLeftPageOdd(List<Integer> pages) {
        return pages.get(LEFT_PAGE) % 2 == 1;
    }

    private static boolean isSuccessivePages(List<Integer> pages) {
        return pages.get(RIGHT_PAGE) - pages.get(LEFT_PAGE) == 1;
    }
}