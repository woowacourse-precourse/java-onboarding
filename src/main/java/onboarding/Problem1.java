package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        if (checkException(pobi) || checkException(crong)) {
            return -1;
        }

        int pobiScore = maxScore(pobi);
        int crongScore = maxScore(crong);

        if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }


    public static boolean checkException(List<Integer> pages) {
        boolean result = false;
        int start = 1, end = 400;

        if (pages.get(0) + 1 != pages.get(1)) {
            result = true;
        }

        if (pages.get(0) == start || pages.get(1) == end) {
            result = true;
        }

        return result;
    }


    public static int maxScore(List<Integer> pages) {
        int page1 = pageMax(pages.get(0));
        int page2 = pageMax(pages.get(1));

        return Math.max(page1, page2);
    }


    public static int pageMax(int page) {
        List<Integer> nums = new ArrayList<>();

        while (page > 0) {
            nums.add(page % 10);
            page /= 10;
        }

        int sum = 0, mul = 1;
        for (int num: nums) {
            sum += num;
            mul *= num;
        }

        return Math.max(sum, mul);
    }
}
