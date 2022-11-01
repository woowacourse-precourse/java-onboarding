package onboarding;

import java.util.List;

class Problem1 {

    private static final int EXCEPTION = -1;
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isException(pobi) && isException(crong)) {
            int pobiMaxNum = getMaxNumber(pobi.get(0),pobi.get(1));
            int crongMaxNum = getMaxNumber(crong.get(0),crong.get(1));

            return getWinner(pobiMaxNum, crongMaxNum);
        }
        return EXCEPTION;
    }

    public static int getWinner(Integer pobiMaxNum, Integer crongMaxNum) {
        if (pobiMaxNum.equals(crongMaxNum)) {
            return DRAW;
        }
        if (pobiMaxNum > crongMaxNum) {
            return POBI_WIN;
        }
        return CRONG_WIN;
    }

    public static int getMaxNumber (Integer leftPageNum, Integer rightPageNum) {
        int leftPageMaxNum = calcMax(getSumPageNum(leftPageNum), getMultiplyPageNum(leftPageNum));
        int rightPageMaxNum = calcMax(getSumPageNum(rightPageNum), getMultiplyPageNum(rightPageNum));

        return calcMax(leftPageMaxNum, rightPageMaxNum);
    }

    public static int getSumPageNum(Integer pageNum){
        int sum = 0;
        while (pageNum > 0) {
            sum += pageNum % 10;
            pageNum /= 10;
        }
        return sum;
    }

    public static int getMultiplyPageNum(Integer pageNum) {
        int mul = 1;
        while (pageNum > 0) {
            mul *= pageNum % 10;
            pageNum /= 10;
        }
        return mul;
    }

    public static int calcMax(Integer num1, Integer num2) {
        return Math.max(num1, num2);
    }

    public static boolean isException(List<Integer> page) {
        return isPageRange(page) && isContinuous(page) && isEvenOrOdd(page);
    }

    public static boolean isPageRange (List<Integer> page) {
        return page.get(0) > 1 && page.get(0) < 400 && page.get(1) > 1 && page.get(1) < 400;
    }

    public static boolean isContinuous(List<Integer> page) {
        return page.get(1) - page.get(0) == 1;
    }

    public static boolean isEvenOrOdd(List<Integer> page){
        return page.get(0) % 2 == 1 && page.get(1) % 2 == 0;
    }

}