package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int DRAW = 0;
    public static final int ERROR = -1;
    public static final int MIN_PAGE = 1;
    public static final int MAX_PAGE = 400;
    public static final int RIGHT_PAGE = 1;
    public static final int LEFT_PAGE = 0;
    public static final int PAGE_DIFFERENCE = 1;
    public static final String PAGE_SIZE_ERROR_MESSAGE = "페이지 리스트의 길이가 2가 아닙니다.";
    public static final String PAGE_RANGE_ERROR_MESSAGE = "페이지는 1보다 작을 수 없고 400보다 클 수 없습니다.";
    public static final String PAGE_DIFFERENCE_ERROR_MESSAGE = "두 페이지의 차이는 1이어야만 합니다.";

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Integer pobiMax = getMaxResult(pobi);
            Integer crongMax = getMaxResult(crong);
            return getGameResult(pobiMax, crongMax);
        } catch (IllegalArgumentException e) {
            return ERROR;
        }
    }

    private static int getGameResult(Integer pobiMax, Integer crongMax) {
        if (pobiMax > crongMax) {
            return POBI_WIN;
        }
        if (crongMax > pobiMax) {
            return CRONG_WIN;
        }
        return DRAW;
    }

    private static Integer getMaxResult(List<Integer> pages) {
        if (pages.size() != 2) {
            throw new IllegalArgumentException(PAGE_SIZE_ERROR_MESSAGE);
        }
        if (checkPageRange(pages)) {
            throw new IllegalArgumentException(PAGE_RANGE_ERROR_MESSAGE);
        }
        if (checkPageDifference(pages)) {
            throw new IllegalArgumentException(PAGE_DIFFERENCE_ERROR_MESSAGE);
        }
        return pages.stream()
            .map(page -> getEachDigits(page))
            .mapToInt(digits -> getBiggerNumber(addEachDigits(digits), multiplyEachDigits(digits)))
            .max()
            .getAsInt();
    }

    private static boolean checkPageDifference(List<Integer> pages) {
        return pages.get(RIGHT_PAGE) - pages.get(LEFT_PAGE) != PAGE_DIFFERENCE;
    }

    private static boolean checkPageRange(List<Integer> pages) {
        return pages.stream()
            .anyMatch(page -> checkNumberRange(page));
    }

    private static boolean checkNumberRange(Integer page) {
        return page < MIN_PAGE || page > MAX_PAGE;
    }

    public static int[] getEachDigits(int page) {
        return Arrays.stream(String.valueOf(page).split(""))
            .mapToInt(Integer::parseInt)
            .toArray();
    }

    public static int addEachDigits(int[] digits) {
        return Arrays.stream(digits).sum();
    }

    public static int multiplyEachDigits(int[] digits) {
        return Arrays.stream(digits)
            .reduce(1, Math::multiplyExact);
    }

    public static int getBiggerNumber(int numberA, int numberB) {
        if (numberA > numberB) {
            return numberA;
        }
        return numberB;
    }
}