package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkError(pobi) || checkError(crong)) {
            return -1;
        }

        int pobiMax = compareLeftRight(pobi.get(0), pobi.get(1));
        int crongMax = compareLeftRight(crong.get(0), crong.get(1));
        int answer = getWinner(pobiMax, crongMax);

        return answer;
    }

    private static boolean checkError(List<Integer> pages) {
        if (pages.get(0) == null || pages.get(1) == null) {
            return true;
        }

        return pages.get(1) - pages.get(0) != 1;
    }

    private static int getMaxPage(int page) {
        int num = 0;
        int sum = 0;
        int mul = 1;

        while (page > 0) {
            num = page % 10;
            sum += num;
            mul *= num;
            page /= 10;
        }

        return Math.max(sum, mul);
    }

    private static int compareLeftRight(int leftPage, int rightPage) {
        int left = getMaxPage(leftPage);
        int right = getMaxPage(rightPage);

        return Math.max(left, right);
    }

    private static int getWinner(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        }

        if (pobiScore < crongScore) {
            return 2;
        }

        return 0;
    }
}
