package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!(isValidInput(pobi)&&isValidInput(crong))) {
            return -1;
        }

        int pobiMax = getPlayerMax(pobi);
        int crongMax = getPlayerMax(crong);

        return compareMax(pobiMax, crongMax);
    }

    private static boolean isValidInput(List<Integer> pages) {
        return isValidRange(pages) && isContinuousNumber(pages) && isCorrectPage(pages);
    }

    private static boolean isValidRange(List<Integer> pages) {
        for (int page : pages) {
            //첫 페이지, 마지막 페이지는 펼치면 안되기 때문에 3~398의 범위를 가져야 합니다.
            if (page < 3 || 398 < page) {
                return false;
            }
        }
        return true;
    }

    private static boolean isContinuousNumber(List<Integer> pages) {
        int diff = Math.abs(pages.get(0) - pages.get(1));

        return diff == 1;
    }

    private static boolean isCorrectPage(List<Integer> pages) {
        return (pages.get(0) % 2 == 1) && (pages.get(1) % 2 == 0);
    }

    private static int getPlayerMax(List<Integer> player) {
        int addMax = getAddMax(player);
        int multMax = getMultiMax(player);

        return Math.max(addMax, multMax);
    }

    private static int getAddMax(List<Integer> pages) {
        int max = 0;

        for (int page : pages) {
            max = Math.max(max, getAddResult(page));
        }

        return max;
    }

    private static int getAddResult(int page) {
        int sum = 0;

        while (page > 0) {
            sum += page % 10;
            page /= 10;
        }

        return sum;
    }

    private static int getMultiMax(List<Integer> pages) {
        int max = 0;

        for (int page : pages) {
            max = Math.max(max, getMultiResult(page));
        }

        return max;
    }

    private static int getMultiResult(int page) {
        //곱하는 연산이므로 초기값을 1로 둔다.
        int result = 1;

        while (page > 0) {
            result *= page % 10;
            page /= 10;
        }

        return result;
    }

    private static int compareMax(int pobiMax, int crongMax) {
        if (crongMax > pobiMax) {
            return 2;
        } else if (pobiMax > crongMax) {
            return 1;
        } else {
            return 0;
        }
    }
}