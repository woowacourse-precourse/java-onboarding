package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Integer pobiMax = getMaxResult(pobi);
            Integer crongMax = getMaxResult(crong);
            return getGameResult(pobiMax, crongMax);
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

    private static int getGameResult(Integer pobiMax, Integer crongMax) {
        if (pobiMax > crongMax) {
            return 1;
        }
        if (crongMax > pobiMax) {
            return 2;
        }
        return 0;
    }

    private static Integer getMaxResult(List<Integer> pages) {
        if (pages.size() != 2) {
            throw new IllegalArgumentException("페이지 리스트의 길이가 2가 아닙니다.");
        }
        if (checkPageRange(pages)) {
            throw new IllegalArgumentException("페이지는 1보다 작을 수 없고 400보다 클 수 없습니다.");
        }
        if (checkPageDifference(pages)) {
            throw new IllegalArgumentException("두 페이지의 차이는 1이어야만 합니다.");
        }
        return pages.stream()
            .map(page -> getEachDigits(page))
            .mapToInt(digits -> getBiggerNumber(addEachDigits(digits), multiplyEachDigits(digits)))
            .max()
            .getAsInt();
    }

    private static boolean checkPageDifference(List<Integer> pages) {
        return pages.get(1) - pages.get(0) != 1;
    }

    private static boolean checkPageRange(List<Integer> pages) {
        return pages.stream()
            .anyMatch(page -> checkNumberRange(page));
    }

    private static boolean checkNumberRange(Integer page) {
        return page < 1 || page > 400;
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