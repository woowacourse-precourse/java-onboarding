package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isException(pobi) || isException(crong)) {
            return -1;
        }

        int pobiScore = Math.max(maxValue(pobi.get(0)), maxValue(pobi.get(1)));
        int crongScore = Math.max(maxValue(crong.get(0)), maxValue(crong.get(1)));

        if (pobiScore == crongScore)
            return 0;
        if (pobiScore > crongScore)
            return 1;
        return 2;
    }

    public static boolean isException(List<Integer> pages) {
        int left = pages.get(0);
        int right = pages.get(1);
        return left + 1 != right || left == 0 || right == 400;
    }

    public static int maxValue(int number) {
        int sum = 0;
        int multiplication = 1;
        while (number != 0) {
            int now = number % 10;
            sum += now;
            multiplication *= now;
            number = number / 10;
        }

        return Math.max(sum, multiplication);
    }
}