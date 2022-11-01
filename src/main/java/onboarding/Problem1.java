package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!checkPages(pobi) || !checkPages(crong)) {
            answer = -1;
            return answer;
        }

        answer = getBigNumberInPair(getBigNumberInPages(pobi.get(0), pobi.get(1)),
            getBigNumberInPages(crong.get(0), crong.get(1)));

        return answer;
    }

    private static int getBigNumberInPages(int leftPage, int rightPage) {
        int maxLeftSum = getBigNumberInPage(leftPage);
        int maxRigntSum = getBigNumberInPage(rightPage);
        if (maxLeftSum >= maxRigntSum) {
            return maxLeftSum;
        } else {
            return maxRigntSum;
        }
    }

    private static int getBigNumberInPage(int page) {
        int plusSum = 0;
        int multiSum = 1;

        int q = page / 100;
        if (q != 0) {
            multiSum *= q;
        }
        plusSum += q;
        page %= 100;

        q = page / 10;
        if (q != 0) {
            multiSum *= q;
        }
        plusSum += q;
        page %= 10;

        plusSum += page;
        multiSum *= page;

        if (plusSum >= multiSum) {
            return plusSum;
        } else {
            return multiSum;
        }
    }

    private static boolean checkPages(List<Integer> list) {
        int leftPage = list.get(0);
        int rightPage = list.get(1);
        if ((leftPage + 1) != rightPage || (leftPage % 2 == 0) || (rightPage % 2 == 1) ||
            (leftPage == 1) || (rightPage == 400)) {
            return false;
        }
        return true;
    }
}
