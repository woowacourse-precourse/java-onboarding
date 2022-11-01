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

    // 예외 케이스면 false 반환
    public static boolean checkException(List<Integer> pages) {
        boolean result = true;
        int page1 = pages.get(0), page2 = pages.get(1);
        int start = 1, end = 400;

        if (page1 + 1 != page2) result = false; // 연속된 페이지가 아닌 경우
        if (page1 % 2 != 1 || page2 % 2 != 0) result = false; // 홀수, 짝수 페이지 조건 안맞는 경우
        if (page1 <= start || page2 >= end) result = false; // 첫페이지, 마지막 페이지 포함하는 경우

        return result;
    }

    // 어떤 페이지에 대해서 구할 수 있는 가장 큰 연산 값
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
