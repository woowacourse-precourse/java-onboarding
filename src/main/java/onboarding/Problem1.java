package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static final int EXCEPTION = -1;
    public static final int DRAW = 0;
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int MIN_PAGE = 1;
    public static final int MAX_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isException(pobi) || isException(crong))
            return EXCEPTION;

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        return (pobiScore == crongScore) ? DRAW : (pobiScore > crongScore) ? POBI_WIN : CRONG_WIN;
    }

    public static int getScore(List<Integer> page) {
        return Math.max(getPossibleMax(page.get(0)), getPossibleMax(page.get(1)));
    }

    public static int getPossibleMax(int num) {
        return Math.max(getSum(num), getProduct(num));
    }

    public static int getSum(int num) {
        return Stream.of(String.valueOf(num).split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public static int getProduct(int num) {
        return Stream.of(String.valueOf(num).split(""))
                .mapToInt(Integer::parseInt)
                .reduce(1, (a,b) -> a * b);
    }

    public static boolean isException(List<Integer> pages) {
        int left = pages.get(0);
        int right = pages.get(1);

        if(left < MIN_PAGE || left > MAX_PAGE || right < MIN_PAGE || right > MAX_PAGE)
            return true;
        if(left % 2 == 0 || right % 2 != 0)
            return true;
        if(left >= right || right - left > 1)
            return true;

        return false;
    }

}