package onboarding;

import java.util.List;

class Problem1 {
    private static boolean checkList(List<Integer> list) {
        if (list.size() != 2)
            return true;
        if (list.get(0) % 2 == 0 || list.get(1) != (list.get(0) + 1))
            return true;
        // 시작면 : 1, 마지막면 : 400 제외
        return list.get(0) <= 1 || list.get(1) >= 400;
    }

    private static int getPlusNumber(int leftPage) {
        int result = 0;
        while (leftPage != 0) {
            result += leftPage % 10;
            leftPage /= 10;
        }
        return result;
    }

    private static int getMultiNumber(int rightPage) {
        int result = 1;
        while (rightPage != 0) {
            result *= rightPage % 10;
            rightPage /= 10;
        }
        return result;
    }

    private static int maxNumber(List<Integer> list) {
        int plusNumber = getPlusNumber(list.get(0));
        int multiNumber = getMultiNumber(list.get(1));

        return Math.max(plusNumber, multiNumber);
    }

    private static int getWinner(List<Integer> pobi, List<Integer> crong) {
        int pobiNumber = maxNumber(pobi);
        int crongNumber = maxNumber(crong);

        if (pobiNumber > crongNumber)
            return 1;
        if (pobiNumber == crongNumber)
            return 0;
        return 2;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkList(pobi) || checkList(crong))
            return -1;
        return getWinner(pobi, crong);
    }
}