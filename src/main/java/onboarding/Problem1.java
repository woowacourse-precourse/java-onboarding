package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
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