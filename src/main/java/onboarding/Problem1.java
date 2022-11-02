package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!validData(pobi, crong)) return -1;

        int pobiScore = getMaxScore(pobi);
        int crongScore = getMaxScore(crong);


        if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer = 2;
        } else {
            answer = 0;
        }
        return answer;
    }

    private static boolean validData(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0) < 1 || crong.get(0) < 1 || pobi.get(1) > 400 || crong.get(1) > 400) return false;
        if (pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1 || pobi.get(1) % 2 != 0 || crong.get(1) % 2 != 0)
            return false;
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) return false;
        return true;
    }

    private static int getMaxScore(List<Integer> pages) {
        int rightPage = pages.get(1);
        int leftPage = pages.get(0);
        return Math.max(getPageScore(leftPage), getPageScore(rightPage));
    }

    private static int getPageScore(int page) {
        int sum = 0;
        int temp = page;
        int pageSize = (int) Math.log10(page) + 1;
        for (int i = 0; i < pageSize; i++) {
            sum += temp % 10;
            temp /= 10;
        }

        int duplicate = 1;
        temp = page;
        for (int i = 0; i < pageSize; i++) {
            duplicate *= temp % 10;
            temp /= 10;
        }

        return Math.max(sum, duplicate);
    }
}