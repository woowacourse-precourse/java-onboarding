package onboarding;

import java.util.List;

class Problem1 {
    private static final int PAGE_COUNT = 2;
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int EXCEPTION = -1;
    private static final int TIE = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isNotConsecutive(pobi) || isNotConsecutive(crong)
                || isNotCorrectPage(pobi) || isNotCorrectPage(crong)) {
            return EXCEPTION;
        }

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);
        if (pobiScore > crongScore) {
            return POBI_WIN;
        }
        if (pobiScore < crongScore) {
            return CRONG_WIN;
        }
        return TIE;
    }

    private static boolean isNotConsecutive(List<Integer> pobi) {
        return pobi.get(RIGHT) - pobi.get(LEFT) != 1;
    }

    private static boolean isNotCorrectPage(List<Integer> pobi) {
        return pobi.size() != PAGE_COUNT;
    }

    private static int getScore(List<Integer> pages) {
        return Math.max(getMax(pages.get(LEFT)), getMax(pages.get(RIGHT)));
    }

    private static int getMax(int page) {
        int sum = page % 10;
        int multi = page % 10;
        page /= 10;
        while (page > 0) {
            int number = page % 10;
            sum += number;
            multi *= number;
            page /= 10;
        }
        return Math.max(sum, multi);
    }
}
