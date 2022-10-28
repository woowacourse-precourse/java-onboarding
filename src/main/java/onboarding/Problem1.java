package onboarding;

import java.util.List;

class Problem1 {
    private static int addDigit(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n /= 10;
        }
        return (result);
    }

    private static int multiDigit(int n) {
        int result = 1;
        while (n > 0) {
            result *= n % 10;
            n /= 10;
        }
        return (result);
    }

    private static int maxPage(List<Integer> pages) {
        int max = Integer.MIN_VALUE;
        for (int p : pages) {
            int addSum = addDigit(p);
            int multiSum = multiDigit(p);
            if (max < addSum) {
                max = addSum;
            }
            if (max < multiSum) {
                max = multiSum;
            }
        }
        return (max);
    }

    private static boolean isValidInput(List<Integer> page) {
        int left = page.get(0);
        int right = page.get(1);

        if(left < 2 || left > 399 ||
                    right < 2 || right > 399)
            return (false);
        if (left % 2 == 0 || right % 2 == 1 || right - left != 1) {
            return (false);
        }

        return (true);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!isValidInput(pobi) || !isValidInput(crong)) {
            return (-1);
        }

        int max_pobi = maxPage(pobi);
        int max_crong = maxPage(crong);

        if (max_pobi > max_crong) {
            answer = 1;
        }
        else if (max_crong < max_pobi) {
            answer = 2;
        }
        else {
            answer = 0;
        }
        return answer;
    }
}