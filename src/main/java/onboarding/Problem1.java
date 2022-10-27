package onboarding;

import java.util.List;

class Problem1 {
    private static final int EXCEPTION_CASE = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!isBoundary(pobi) || !isBoundary(crong)) return EXCEPTION_CASE;
        return answer;
    }

    private static int getPageScore(int page) {
        return Math.max(sumDigits(page), productDigits(page));
    }

    private static int sumDigits(int page) {
        int sum = 0;
        String pageStr = Integer.toString(page);
        for (int i = 0; i < pageStr.length(); i++) {
            sum += pageStr.charAt(i) - '0';
        }
        return sum;
    }

    private static int productDigits(int page) {
        int result = 1;
        String pageStr = Integer.toString(page);
        for (int i = 0; i < pageStr.length(); i++) {
            result *= pageStr.charAt(i) - '0';
        }
        return result;
    }

    private static boolean isBoundary(List<Integer> pages) {
        return 3 <= pages.get(0) && pages.get(1) <= 398;
    }
}