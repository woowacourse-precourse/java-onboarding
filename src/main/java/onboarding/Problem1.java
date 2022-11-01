package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!isValid(pobi) || !isValid(crong)) {
            answer = -1;
        }

        return answer;
    }

    private static boolean isValid(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (leftPage <= 1 || rightPage >= 400 || leftPage + 1 != rightPage) {
            return false;
        }
        return true;
    }

    public static int maxNumForAPage(int page) {
        int sum = 0;
        int multiply = 1;

        while (page != 0) {
            int number = page % 10;
            page /=10;
            sum += number;
            multiply *= number;
        }

        return Math.max(sum, multiply);
    }
}

