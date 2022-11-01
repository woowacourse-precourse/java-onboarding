package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        if (checkException(pobi) && checkException(crong)) {
            int pobiScore = Math.max(pageMax(pobi.get(0)), pageMax(pobi.get(1)));
            int crongScore = Math.max(pageMax(crong.get(0)), pageMax(crong.get(1)));

            if (pobiScore > crongScore) answer = 1;
            else if (pobiScore < crongScore) answer = 2;
            else if (pobiScore == crongScore) answer = 0;
        }

        return answer;
    }


    public static boolean checkException(List<Integer> pages) {
        boolean result = true;
        int start = 1, end = 400;

        if (pages.get(0) + 1 != pages.get(1)) result = false;
        if (pages.get(0) <= start || pages.get(1) >= end) result = false;

        return result;
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
