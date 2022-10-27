package onboarding;

import java.util.List;

class Problem1 {
    private static final int EXCEPTION = -1;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int TIE_GAME = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!isvalidPages(pobi) || !isvalidPages(crong)) {
            return EXCEPTION;
        }

        return answer;
    }

    public static boolean isvalidPages(List<Integer> pages) {
        if (pages.size() != 2 || pages.get(0) == 0 || pages.get(1) == 400 || pages.get(0) % 2 != 1 || pages.get(1) % 2 != 0 || pages.get(0) + 1 != pages.get(1)) {
            return false;
        }

        return true;
    }

    public static int sumEachDigitOfPage(int page) {
        int num = 0;

        while (page > 0) {
            num += page % 10;
            page /= 10;
        }

        return num;
    }

    public static int multiplyEachDigitOfPage(int page) {
        int num = 1;

        while (page > 0) {
            num *= page % 10;
            page /= 10;
        }

        return num;
    }
}