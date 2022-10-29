package onboarding;

import java.util.List;

class Problem1 {
    private int pageSumMul(int pageNum) {
        int sum = 0, multiply = 1;
        while(pageNum > 0) {
            sum += pageNum % 10;
            multiply *= pageNum % 10;
            pageNum /= 10;
        }

        return sum > multiply ? sum : multiply;
    }
    private int calcScore(List<Integer> page) {
        // 왼쪽 페이지 계산
        int leftScore = pageSumMul(page.get(0));
        int rightScore = pageSumMul(page.get(1));

        return leftScore > rightScore ? leftScore : rightScore;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiSocre = calcScore(pobi), crongScore = calcScore(crong);

        return answer;
    }
}