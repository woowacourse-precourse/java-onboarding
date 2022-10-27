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
        return pages.stream()
            .map(page -> getEachDigits(page))
            .mapToInt(digits -> getBiggerNumber(addEachDigits(digits), multiplyEachDigits(digits)))
            .max()
            .getAsInt();
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