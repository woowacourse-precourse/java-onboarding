package onboarding;

import java.util.List;

class Problem1 {
    private static boolean checkList(List<Integer> list) {
        if (list.size() != 2)
            return false;
        if (list.get(0) % 2 == 0 || list.get(1) != (list.get(0) + 1))
            return false;
        if (list.get(0) <= 1 || list.get(1) >= 400)
            return false;
        return true;
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

    public static int solution(List<Integer> pobi, List<Integer> crong) {

    }

}