package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = pageNumberException(pobi, crong);
        if(answer == -1){
            return answer;
        }
        for(int i = 0; i < 2; i ++){
            pageNumberHighScore(pobi, i);
            pageNumberHighScore(crong, i);
        }
        return answer;
    }

    private static int pageNumberException(List<Integer> pobi, List<Integer> crong) {
        if((pobi.get(0)+1 != pobi.get(1)) || (crong.get(0)+1 != crong.get(1))){
            return -1;
        }
        return 0;
    }

    private static int pageNumberHighScore(List<Integer> pageNumberList, int direction) {
        int digitSum = 0;
        int digitMul = 0;
        int score = pageNumberList.get(direction);
        while(score > 0) {
            digitSum += score % 10;
            digitMul *= score % 10;
            score = score / 10;
        }
        if(digitMul > digitSum) return digitMul;
        if(digitMul < digitSum) return digitSum;

        return digitMul;
    }
}