package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 p1 = new Problem1();
        int pobiScore = p1.getScore(pobi);
        int crongScore = p1.getScore(crong);

        if (!p1.validateList(pobi) || !p1.validateList(crong)) {
            return -1;
        }

        if (pobiScore > crongScore) {
            return 1;
        }

        if (pobiScore < crongScore) {
            return 2;
        }

        return 0;
    }

    public boolean validateList(List<Integer> pages) {
        if (pages.isEmpty()) {
            return false;
        }

        int left = pages.get(0);
        int right = pages.get(1);

        if (left != right - 1) {
            return false;
        }

        if (left % 2 != 1 || right % 2 != 0) {
            return false;
        }

        return true;
    }


    public int getScore(List<Integer> pages) {
        int left = pages.get(0);
        int right = pages.get(1);
        return getMax(findMaxFromSinglePage(left), findMaxFromSinglePage(right));
    }

    public int findMaxFromSinglePage(int page) {
        int temp = page;
        int add = 0;
        int multi = 1;

        while (temp > 0) {
            add += temp % 10;
            temp /= 10;
        }

        temp = page;

        while (temp > 0) {
            multi *= temp % 10;
            temp /= 10;
        }

        return getMax(add, multi);
    }

    public int getMax(int a, int b) {
        return Math.max(a, b);
    }
}