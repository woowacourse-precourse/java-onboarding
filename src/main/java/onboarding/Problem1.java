package onboarding;

import java.util.List;

class Problem1 {

    private static final int ERROR = -1;
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (errorCheck(pobi, crong)) {
            return ERROR;
        }

        Integer pobiMax = getScore(pobi);
        Integer crongMax = getScore(crong);

        return getWinner(pobiMax, crongMax);
    }

    private static Integer getScore(List<Integer> user) {
        return user.stream()
                .map(Problem1::getMaxValue)
                .max(Integer::compareTo)
                .orElse(ERROR);
    }

    private static boolean errorCheck(List<Integer> pobi, List<Integer> crong) {
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if (pobiLeft - pobiRight != -1) {
            return true;
        }
        if (crongLeft - crongRight != -1) {
            return true;
        }
        if (pobiLeft == 1 || crongLeft == 1) {
            return true;
        }
        if (pobiRight == 400 || crongRight == 400) {
            return true;
        }

        return false;
    }

    private static int getWinner(int pobiMax, int crongMax) {
        if (pobiMax > crongMax) {
            return POBI_WIN;
        }
        if (pobiMax < crongMax) {
            return CRONG_WIN;
        }

        return DRAW;
    }

    private static Integer getMaxValue(Integer page) {
        int sum = 0;
        int mul = 1;
        int seatNum;

        while (page > 0) {
            seatNum = page % 10;
            page /= 10;
            sum += seatNum;
            mul *= seatNum;
        }

        return Math.max(sum, mul);
    }
}