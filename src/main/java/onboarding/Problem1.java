package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isNotValidPages(pobi) || isNotValidPages(crong)) {
            return -1;
        }

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        return 0;
    }

    private static int getScore(List<Integer> pages) {
        int leftPageScore = calculate(pages.get(0));
        int rightPageScore = calculate(pages.get(1));

        return Math.max(leftPageScore, rightPageScore);
    }

    private static int calculate(int page) {
        int sum = 0;
        int mul = 1;

        while (page > 0) {
            int number = page % 10;
            sum += number;
            mul *= number;
            page /= 10;
        }

        return Math.max(sum, mul);
    }

    private static boolean isNotValidPages(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (leftPage % 2 != 1 || rightPage % 2 != 0) {
            return true;
        }

        if (rightPage - leftPage != 1 || rightPage > 400) {
            return true;
        }

        return false;
    }
}