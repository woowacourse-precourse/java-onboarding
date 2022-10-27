package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = getMaxNumber(pobi);
        int crongScore = getMaxNumber(crong);
        return compareScore(pobiScore, crongScore);
    }

    private static int getMaxNumber(List<Integer> page) {
        int leftPage = page.get(0);
        int rightPage = page.get(1);
        int leftPageMaxNumber = Math.max(getMaxNumberWithAdd(leftPage), getMaxNumberWithMultiply(leftPage));
        int rightPageMaxNumber = Math.max(getMaxNumberWithAdd(rightPage), getMaxNumberWithMultiply(rightPage));
        return Math.max(leftPageMaxNumber, rightPageMaxNumber);
    }

    private static int getMaxNumberWithAdd(int pageNumber) {
        String tmp = Integer.toString(pageNumber);
        int ret = 0;
        for (int i = 0; i < tmp.length(); i++) {
            ret += tmp.charAt(i) - '0';
        }
        return ret;
    }

    private static int getMaxNumberWithMultiply(int pageNumber) {
        String tmp = Integer.toString(pageNumber);
        int ret = 1;
        for (int i = 0; i < tmp.length(); i++) {
            ret *= tmp.charAt(i) - '0';
        }
        return ret;
    }

    private static int compareScore(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) return 1;
        else if (pobiScore < crongScore) return 2;
        else return 0;
    }
}