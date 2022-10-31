package onboarding;

import java.util.List;

class Problem1 {
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;
    private static int getMaxScore(int page){
        int sum = 0;
        int multiplication = 1;
        while(page > 0){
            sum += page % 10;
            multiplication *= page % 10;
            page /= 10;
        }
        return Math.max(sum, multiplication);
    }

    private static int determineWinner(int pobiMaxScore, int crongMaxScore){
        if(pobiMaxScore > crongMaxScore) {
            return 1;
        }
        if(pobiMaxScore < crongMaxScore) {
            return 2;
        }
        return 0;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiMaxScore = Integer.MIN_VALUE;
        int crongMaxScore = Integer.MIN_VALUE;

        pobiMaxScore = Math.max(getMaxScore(pobi.get(LEFT_PAGE)), getMaxScore(pobi.get(RIGHT_PAGE)));
        crongMaxScore = Math.max(getMaxScore(crong.get(LEFT_PAGE)), getMaxScore(crong.get(RIGHT_PAGE)));

        answer = determineWinner(pobiMaxScore, crongMaxScore);

        return answer;
    }
}