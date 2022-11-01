package onboarding;

import java.util.List;
import java.util.stream.Stream;

import static java.lang.Math.max;

class Problem1 {
    private static final Integer EXCEPTION = -1;
    private static final Integer PAGE_ERROR = -1;
    private static final Integer DRAW = 0, POBI_WIN = 1, CRONG_WIN = 2;

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

        return leftPage % 2 == 0 || rightPage % 2 == 1 || rightPage - leftPage != 1 || leftPage < 3 || rightPage < 4 || leftPage > 397 || rightPage > 398
            ? PAGE_ERROR
            : max(pageToCalMaxNum(leftPage), pageToCalMaxNum(rightPage));
    }

    private static int pageToCalMaxNum (int page) {
        int[] arrPage = Stream.of(String.valueOf(page).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        int multiply = 1;
        for (int num : arrPage) {
            sum += num;
            multiply *= num;
        }

        return max(sum, multiply);
    }
}