package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    boolean validation(List<Integer> pages) {
        if (pages.size() != 2) return false;
        if (pages.get(0) == 1 || pages.get(1) == 400) return false;
        if (pages.get(0) % 2 == 0) return false;
        return pages.get(1) - pages.get(0) == 0;
    }

    int score(int page) {
        int product = 1;
        int sum = 0;
        while(page > 0) {
            int curr = page % 10;
            product *= curr;
            sum += curr;
            page /= 10;
        }
        return Math.max(product, sum);
    }
}