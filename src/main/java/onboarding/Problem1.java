package onboarding;

import java.util.List;

class Problem1 {
    public static int EXCEPTION = -1;
    public static int POBI_WIN = 1;
    public static int CRONG_WIN = 2;
    public static int DRAW = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiMax = 0;
        int crongMax = 0;


        if (isException(pobi) || isException(crong)) {
            answer = EXCEPTION;
        } else {
            pobiMax = calculatePageMax(pobi);
            crongMax = calculatePageMax(crong);
            answer = makeWinner(pobiMax, crongMax);
        }

        return answer;
    }

    private static boolean isException(List<Integer> pageList) {
        if (pageList.get(1) - pageList.get(0) > 1) {
            return true;
        } else if (pageList.get(1) < pageList.get(0)) {
            return true;
        }

        for (Integer pageNumber : pageList) {
            if (pageNumber > 400) {
                return true;
            }
        }
        return false;
    }

    private static int calculatePageMax(List<Integer> pageList) {
        int max = 0;

        for (Integer pageNumber : pageList) {
            int pageNumberToInt = pageNumber.intValue();
            if (max < seperateOneNumber(pageNumberToInt)) {
                max = seperateOneNumber(pageNumberToInt);
            }
        }
        return max;
    }

    private static int seperateOneNumber(int pageNumberToInt) {
        int plusSum = 0;
        int multiplySum = 1;

        while (pageNumberToInt != 0) {
            plusSum += pageNumberToInt % 10;
            multiplySum *= pageNumberToInt % 10;
            pageNumberToInt /= 10;
        }
        return (plusSum >= multiplySum) ? plusSum : multiplySum;
    }

    private static int makeWinner(int pobiMax, int crongMax) {
        if (pobiMax < crongMax) {
            return CRONG_WIN;
        } else if (pobiMax > crongMax) {
            return POBI_WIN;
        } else {
            return DRAW;
        }
    }
}