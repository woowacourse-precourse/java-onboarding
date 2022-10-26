package onboarding;

import java.util.List;
import java.util.stream.Stream;

import static java.lang.Math.max;

class Problem1 {

    private static final Integer EXCEPTION = -1;
    private static final Integer DRAW = 0;
    private static final Integer POBI_WIN = 1;
    private static final Integer CRONG_WIN = 2;
    private static final Integer PAGE_ERROR = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.size() != 2 || crong.size() != 2)
            return EXCEPTION;

        int pobiNum = maxNum(pobi);
        int crongNum = maxNum(crong);

        if (pobiNum == PAGE_ERROR || crongNum == PAGE_ERROR)
            return EXCEPTION;

        if (pobiNum > crongNum)
            return POBI_WIN;
        else if (pobiNum < crongNum)
            return CRONG_WIN;
        else
            return DRAW;
    }

    private static int maxNum(List<Integer> pageList) {
        int leftPage = pageList.get(0);
        int rightPage = pageList.get(1);

        if (rightPage - leftPage != 1 || leftPage < 1 || rightPage < 1 || leftPage > 400 || rightPage > 400)
            return PAGE_ERROR;

        return max(pageToCalMaxNum(leftPage), pageToCalMaxNum(rightPage));
    }

    private static int pageToCalMaxNum (int page) {
        int[] arrPage = Stream.of(String.valueOf(page).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sumNum = 0;
        int multiplyNum = 1;
        for (int num : arrPage) {
            sumNum += num;
            multiplyNum *= num;
        }

        return max(sumNum, multiplyNum);
    }
}