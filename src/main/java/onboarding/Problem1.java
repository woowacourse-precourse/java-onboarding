package onboarding;

import model.Reader;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isPageFormat(pobi) || !isPageFormat(crong)) {
            return -1;
        }
        Reader readerPobi = new Reader(pobi);
        Reader readerCrong = new Reader(crong);
        return pageGame(readerPobi.getMaxValue(), readerCrong.getMaxValue());
    }

    static int pageGame(int pobiMaxValue, int crongMaxValue) {
        if (pobiMaxValue > crongMaxValue) {
            return 1;
        } else if (pobiMaxValue < crongMaxValue) {
            return 2;
        } else {
            return 0;
        }
    }

    static boolean isPageFormat(List<Integer> page) {
        return page.get(0) + 1 == page.get(1);
    }
}