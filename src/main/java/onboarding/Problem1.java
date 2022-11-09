package onboarding;

import java.util.List;

class Problem1 {
    private static int pageSumMul(int pageNum) {
        int sum = 0, multiply = 1;
        while(pageNum > 0) {
            sum += pageNum % 10;
            multiply *= pageNum % 10;
            pageNum /= 10;
        }

        return sum > multiply ? sum : multiply;
    }
    private static int calcScore(List<Integer> page) {
        // 왼쪽 페이지 계산
        int leftScore = pageSumMul(page.get(0));
        int rightScore = pageSumMul(page.get(1));

        return leftScore > rightScore ? leftScore : rightScore;
    }
    private static boolean checkPage(List<Integer> page) {
        return page.get(0) % 2 == 1 && page.get(1) % 2 == 0 && page.get(1) - page.get(0) == 1;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!checkPage(pobi) || !checkPage(crong)) return -1;
        int pobiSocre = calcScore(pobi), crongScore = calcScore(crong);

        if(pobiSocre > crongScore) return 1;
        else if(pobiSocre < crongScore) return 2;
        else return 0;
    }
}